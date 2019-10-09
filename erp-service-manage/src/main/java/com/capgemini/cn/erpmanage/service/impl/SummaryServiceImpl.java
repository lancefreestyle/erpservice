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
import com.capgemini.cn.erp.domain.QSummary;
import com.capgemini.cn.erp.domain.Summary;
import com.capgemini.cn.erp.domain.SummaryItem;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erp.vo.SummaryDeleteVo;
import com.capgemini.cn.erp.vo.SummaryItemVo;
import com.capgemini.cn.erp.vo.SummaryQueryVo;
import com.capgemini.cn.erp.vo.SummaryVo;
import com.capgemini.cn.erpmanage.service.SummaryService;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class SummaryServiceImpl implements SummaryService {

	@PersistenceContext(unitName = "baseEntityManagerFactory")
	private EntityManager em;

	private QSummary qSummary = QSummary.summary;

	@Override
	public DataResponse<List<SummaryVo>> list(SummaryQueryVo queryVo) {
		// 返回的结果使用SubjectVo实例
		DataResponse<List<SummaryVo>> result = new DataResponse<List<SummaryVo>>();
		JPAQuery<Summary> query = new JPAQuery<Summary>(em).from(qSummary);
		// 根据业务代码和模板代码查询
		if (!StringUtils.isEmpty(queryVo.getSysCode())) {
			query.where(qSummary.sysCode.eq(queryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
			query.where(qSummary.templateCode.eq(queryVo.getTemplateCode()));
		}

		// 根据id正序排列
		query.orderBy(qSummary.id.asc());

		Long totalRec = query.fetchCount();
		int offset = queryVo.getPage() * queryVo.getSize();
		query.offset(offset).limit(queryVo.getSize());
		List<Summary> list = query.fetch();
		List<SummaryVo> resultList = new ArrayList<SummaryVo>();
		if (list != null && list.size() > 0) {
			SummaryVo vo = null;
			for (Summary entity : list) {
				vo = new SummaryVo();
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
	public DataResponse<List<KeyValueVo>> getSummarys(SummaryQueryVo queryVo) {
		DataResponse<List<KeyValueVo>> result = new DataResponse<List<KeyValueVo>>();
		JPAQuery<Summary> query = new JPAQuery<Summary>(em).from(qSummary);
		// 根据业务代码和模板代码查询
		if (!StringUtils.isEmpty(queryVo.getSysCode())) {
			query.where(qSummary.sysCode.eq(queryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
			query.where(qSummary.templateCode.eq(queryVo.getTemplateCode()));
		}

		// 根据id正序排列
		query.orderBy(qSummary.id.asc());
		List<Summary> list = query.fetch();
		List<KeyValueVo> vos = new ArrayList();
		if (!CollectionUtils.isEmpty(list)) {
			for (Summary item : list) {
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
	public DataResponse<SummaryVo> detail(SummaryQueryVo queryVo) {
		DataResponse<SummaryVo> result = new DataResponse<>();
		Summary entity = queryById(queryVo.getId());
		SummaryVo vo = new SummaryVo();
		BeanUtils.copyProperties(entity, vo);
		List<SummaryItemVo> items = new ArrayList<>();
		if (!CollectionUtils.isEmpty(entity.getSummaryItems())) {
			for (SummaryItem item : entity.getSummaryItems()
					) {
				SummaryItemVo itemVo = new SummaryItemVo();
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
	public DataResponse add(SummaryVo vo) {
		Summary entity = new Summary();
		BeanUtils.copyProperties(vo, entity);
		entity.setId(IdUtil.getSnowFlakeStrId());
		if (!CollectionUtils.isEmpty(vo.getItems())) {
			entity.setSummaryItems(new ArrayList<SummaryItem>());
			setItems(entity, vo);
		}
		em.persist(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse update(SummaryVo vo) {
		Summary entity = queryById(vo.getId());
		BeanUtils.copyProperties(vo,entity);
        entity.getSummaryItems().clear();
        if (!CollectionUtils.isEmpty(vo.getItems())) {
			setItems(entity, vo);
		}
		em.merge(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse delete(SummaryDeleteVo deleteVo) {
		Summary entity = queryById(deleteVo.getId());
		em.remove(entity);
		return new DataResponse();
	}

	private Summary queryById(String id) {
		JPAQuery<Summary> query = new JPAQuery<Summary>(em).from(qSummary).where(qSummary.id.eq(id));
		Summary entity = query.fetchOne();
		return entity;
	}

	private void setItems(Summary entity, SummaryVo vo) {
		for (SummaryItemVo itemVo : vo.getItems()) {
			SummaryItem item = new SummaryItem();
			BeanUtils.copyProperties(itemVo, item);
			item.setId(IdUtil.getSnowFlakeStrId());
			entity.addSummaryItem(item);
		}
	}

}
