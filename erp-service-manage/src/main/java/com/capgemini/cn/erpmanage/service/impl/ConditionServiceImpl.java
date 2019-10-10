package com.capgemini.cn.erpmanage.service.impl;

import java.beans.Transient;
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
import com.capgemini.cn.erp.domain.ConditionRule;
import com.capgemini.cn.erp.domain.ConditionRuleItem;
import com.capgemini.cn.erp.domain.QConditionRule;
import com.capgemini.cn.erp.vo.ConditionDeleteVo;
import com.capgemini.cn.erp.vo.ConditionItemVo;
import com.capgemini.cn.erp.vo.ConditionQueryVo;
import com.capgemini.cn.erp.vo.ConditionVo;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erpmanage.service.ConditionService;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class ConditionServiceImpl implements ConditionService {

	@PersistenceContext(unitName = "baseEntityManagerFactory")
	private EntityManager em;

	private QConditionRule qCondition = QConditionRule.conditionRule;

	@Override
	public DataResponse<List<ConditionVo>> list(ConditionQueryVo queryVo) {
		// 返回的结果使用AlarmContactVo实例
		DataResponse<List<ConditionVo>> result = new DataResponse<List<ConditionVo>>();
		JPAQuery<ConditionRule> query = new JPAQuery<ConditionRule>(em).from(qCondition);
		// 根据业务代码和模板代码查询
		if (!StringUtils.isEmpty(queryVo.getSysCode())) {
			query.where(qCondition.sysCode.eq(queryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
			query.where(qCondition.templateCode.eq(queryVo.getTemplateCode()));
		}

		// 根据id正序排列
		query.orderBy(qCondition.id.asc());

		Long totalRec = query.fetchCount();
		int offset = queryVo.getPage() * queryVo.getSize();
		query.offset(offset).limit(queryVo.getSize());
		List<ConditionRule> list = query.fetch();
		List<ConditionVo> resultList = new ArrayList<ConditionVo>();
		if (list != null && list.size() > 0) {
			ConditionVo vo = null;
			for (ConditionRule entity : list) {
				vo = new ConditionVo();
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
	public DataResponse<List<ConditionVo>> listAll() {
		// 返回的结果使用AlarmContactVo实例
		DataResponse<List<ConditionVo>> result = new DataResponse<List<ConditionVo>>();
		JPAQuery<ConditionRule> query = new JPAQuery<ConditionRule>(em).from(qCondition);
		// 根据id正序排列
		query.orderBy(qCondition.id.asc());
		List<ConditionRule> list = query.fetch();
		List<ConditionVo> resultList = new ArrayList<ConditionVo>();
		if (list != null && list.size() > 0) {
			ConditionVo vo = null;
			for (ConditionRule entity : list) {
				vo = new ConditionVo();
				BeanUtils.copyProperties(entity, vo);
				if (StringUtils.isNotBlank(entity.getEnabled()) && "false".equals(entity.getEnabled())) {
					vo.setEnabled(false);
				}
				resultList.add(vo);
			}
		}
		result.setDataStatus(DataStatus.SUCCESS);
		result.setResponse(resultList);
		return result;
	}


	@Override
	public DataResponse<List<KeyValueVo>> getConditions(ConditionQueryVo queryVo) {
		DataResponse<List<KeyValueVo>> result = new DataResponse<List<KeyValueVo>>();
		JPAQuery<ConditionRule> query = new JPAQuery<ConditionRule>(em).from(qCondition);
		// 根据业务代码和模板代码查询
		if (!StringUtils.isEmpty(queryVo.getSysCode())) {
			query.where(qCondition.sysCode.eq(queryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
			query.where(qCondition.templateCode.eq(queryVo.getTemplateCode()));
		}

		// 根据id正序排列
		query.orderBy(qCondition.id.asc());
		List<ConditionRule> list = query.fetch();
		List<KeyValueVo> vos = new ArrayList();
		if (!CollectionUtils.isEmpty(list)) {
			for (ConditionRule item : list) {
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
	public DataResponse<ConditionVo> detail(ConditionQueryVo queryVo) {
		DataResponse<ConditionVo> result = new DataResponse<ConditionVo>();
		ConditionRule entity = queryById(queryVo.getId());
		ConditionVo vo = new ConditionVo();
		BeanUtils.copyProperties(entity, vo);
        if (StringUtils.isNotBlank(entity.getEnabled()) && "false".equals(entity.getEnabled())) {
            vo.setEnabled(false);
        }
		List<ConditionItemVo> items = new ArrayList<>();
		if (!CollectionUtils.isEmpty(entity.getConditionRuleItems())) {
			for (ConditionRuleItem item : entity.getConditionRuleItems()
					) {
				ConditionItemVo itemVo = new ConditionItemVo();
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
	public DataResponse add(ConditionVo vo) {
		ConditionRule entity = new ConditionRule();
		BeanUtils.copyProperties(vo,entity);
		entity.setId(IdUtil.getSnowFlakeStrId());
		if (!CollectionUtils.isEmpty(vo.getItems())) {
			entity.setConditionRuleItems(new ArrayList<ConditionRuleItem>());
			setItems(entity, vo);
		}
		em.persist(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse update(ConditionVo vo) {
		ConditionRule entity = queryById(vo.getId());
		BeanUtils.copyProperties(vo,entity);
        entity.getConditionRuleItems().clear();
        if (!CollectionUtils.isEmpty(vo.getItems())) {
			setItems(entity, vo);
		}
		em.merge(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse delete(ConditionDeleteVo deleteVo) {
		ConditionRule entity = queryById(deleteVo.getId());
		em.remove(entity);
		return new DataResponse();
	}

	private ConditionRule queryById(String id) {
		JPAQuery<ConditionRule> query = new JPAQuery<ConditionRule>(em).from(qCondition).where(qCondition.id.eq(id));
		ConditionRule entity = query.fetchOne();
		return entity;
	}

	private void setItems(ConditionRule entity, ConditionVo vo) {
		for (ConditionItemVo itemVo : vo.getItems()) {
			ConditionRuleItem item = new ConditionRuleItem();
			BeanUtils.copyProperties(itemVo, item);
			item.setId(IdUtil.getSnowFlakeStrId());
			entity.addConditionRuleItem(item);
		}
	}
}
