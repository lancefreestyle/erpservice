package com.capgemini.cn.erpmanage.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.capgemini.cn.core.response.DataPage;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.core.utils.IdUtil;
import com.capgemini.cn.erp.domain.QSubject;
import com.capgemini.cn.erp.domain.Subject;
import com.capgemini.cn.erp.domain.SubjectItem;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erp.vo.SubjectDeleteVo;
import com.capgemini.cn.erp.vo.SubjectItemVo;
import com.capgemini.cn.erp.vo.SubjectQueryVo;
import com.capgemini.cn.erp.vo.SubjectVo;
import com.capgemini.cn.erpmanage.service.SubjectService;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class SubjectServiceImpl implements SubjectService {

	@PersistenceContext(unitName = "baseEntityManagerFactory")
	private EntityManager em;

	private QSubject qSubject = QSubject.subject;

	@Override
	public DataResponse<List<SubjectVo>> list(SubjectQueryVo queryVo) {
		// 返回的结果使用SubjectVo实例
		DataResponse<List<SubjectVo>> result = new DataResponse<List<SubjectVo>>();
		JPAQuery<Subject> query = new JPAQuery<Subject>(em).from(qSubject);
		// 根据业务代码和模板代码查询
		if (!StringUtils.isEmpty(queryVo.getSysCode())) {
			query.where(qSubject.sysCode.eq(queryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
			query.where(qSubject.templateCode.eq(queryVo.getTemplateCode()));
		}

		// 根据id正序排列
		query.orderBy(qSubject.id.asc());

		Long totalRec = query.fetchCount();
		int offset = queryVo.getPage() * queryVo.getSize();
		query.offset(offset).limit(queryVo.getSize());
		List<Subject> list = query.fetch();
		List<SubjectVo> resultList = new ArrayList<SubjectVo>();
		if (list != null && list.size() > 0) {
			SubjectVo vo = null;
			for (Subject entity : list) {
				vo = new SubjectVo();
				BeanUtils.copyProperties(entity, vo);
                if (StringUtils.isNotBlank(entity.getEnabled()) && "false".equals(entity.getEnabled())) {
                    vo.setEnabled(false);
                }
				resultList.add(vo);
			}
		}
		result.setDataStatus(DataStatus.SUCCESS);
		DataPage page = new DataPage();
		page.setTotalElements(totalRec);
		result.setPages(page);
		result.setResponse(resultList);
		return result;
	}

	@Override
	public DataResponse<List<KeyValueVo>> getSubjects(SubjectQueryVo queryVo) {
		DataResponse<List<KeyValueVo>> result = new DataResponse<List<KeyValueVo>>();
		JPAQuery<Subject> query = new JPAQuery<Subject>(em).from(qSubject);
		// 根据业务代码和模板代码查询
		if (!StringUtils.isEmpty(queryVo.getSysCode())) {
			query.where(qSubject.sysCode.eq(queryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
			query.where(qSubject.templateCode.eq(queryVo.getTemplateCode()));
		}

		// 根据id正序排列
		query.orderBy(qSubject.id.asc());
		List<Subject> list = query.fetch();
		List<KeyValueVo> vos = new ArrayList();
		if (!CollectionUtils.isEmpty(list)) {
			for (Subject item : list) {
				KeyValueVo vo = new KeyValueVo();
				vo.setCode(item.getId());
				vo.setName(item.getName());
				vos.add(vo);
			}
		}
		result.setDataStatus(DataStatus.SUCCESS);
		result.setResponse(vos);
		return result;
	}

	@Override
	public DataResponse<SubjectVo> detail(SubjectQueryVo queryVo) {
		DataResponse<SubjectVo> result = new DataResponse<SubjectVo>();
		Subject entity = queryById(queryVo.getId());
		SubjectVo vo = new SubjectVo();
		BeanUtils.copyProperties(entity, vo);
		List<SubjectItemVo> items = new ArrayList<>();
		if (!CollectionUtils.isEmpty(entity.getSubjectItems())) {
			for (SubjectItem item : entity.getSubjectItems()
					) {
				SubjectItemVo itemVo = new SubjectItemVo();
				BeanUtils.copyProperties(item, itemVo);
				items.add(itemVo);
			}
		}
		vo.setItems(items);
		result.setDataStatus(DataStatus.SUCCESS);
		result.setResponse(vo);
		return result;
	}

	@Override
	@Transactional
	public DataResponse add(SubjectVo vo) {
		Subject entity = new Subject();
		BeanUtils.copyProperties(vo,entity);
		entity.setId(IdUtil.getSnowFlakeStrId());
		if (!CollectionUtils.isEmpty(vo.getItems())) {
			entity.setSubjectItems(new ArrayList<SubjectItem>());
			setItems(entity, vo);
		}
		em.persist(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse update(SubjectVo vo) {
		Subject entity = queryById(vo.getId());
		BeanUtils.copyProperties(vo,entity);
        entity.getSubjectItems().clear();
        if (!CollectionUtils.isEmpty(vo.getItems())) {
			setItems(entity, vo);
		}
		em.merge(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse delete(SubjectDeleteVo deleteVo) {
		Subject entity = queryById(deleteVo.getId());
		em.remove(entity);
		return new DataResponse();
	}

	private Subject queryById(String id) {
		JPAQuery<Subject> query = new JPAQuery<Subject>(em).from(qSubject).where(qSubject.id.eq(id));
		Subject entity = query.fetchOne();
		return entity;
	}

	private void setItems(Subject entity, SubjectVo vo) {
		for (SubjectItemVo itemVo : vo.getItems()
				) {
			SubjectItem item = new SubjectItem();
			BeanUtils.copyProperties(itemVo, item);
			item.setId(IdUtil.getSnowFlakeStrId());
			entity.addSubjectItem(item);
		}
	}
}