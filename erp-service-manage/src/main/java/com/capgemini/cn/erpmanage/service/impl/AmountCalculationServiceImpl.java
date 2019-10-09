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
import com.capgemini.cn.erp.domain.AmountCalculation;
import com.capgemini.cn.erp.domain.AmountCalculationItem;
import com.capgemini.cn.erp.domain.QAmountCalculation;
import com.capgemini.cn.erp.vo.AmountCalculationDeleteVo;
import com.capgemini.cn.erp.vo.AmountCalculationItemVo;
import com.capgemini.cn.erp.vo.AmountCalculationQueryVo;
import com.capgemini.cn.erp.vo.AmountCalculationVo;
import com.capgemini.cn.erp.vo.KeyValueVo;
import com.capgemini.cn.erpmanage.service.AmountCalculationService;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class AmountCalculationServiceImpl implements AmountCalculationService {

	@PersistenceContext(unitName = "baseEntityManagerFactory")
	private EntityManager em;

	private QAmountCalculation qAmountCalculation = QAmountCalculation.amountCalculation;

	@Override
	public DataResponse<List<AmountCalculationVo>> list(AmountCalculationQueryVo queryVo) {
		// 返回的结果使用AlarmContactVo实例
		DataResponse<List<AmountCalculationVo>> result = new DataResponse<List<AmountCalculationVo>>();
		JPAQuery<AmountCalculation> query = new JPAQuery<AmountCalculation>(em).from(qAmountCalculation);
		// 根据业务代码和模板代码查询
		if (!StringUtils.isEmpty(queryVo.getSysCode())) {
			query.where(qAmountCalculation.sysCode.eq(queryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
			query.where(qAmountCalculation.templateCode.eq(queryVo.getTemplateCode()));
		}

		// 根据id正序排列
		query.orderBy(qAmountCalculation.id.asc());

		Long totalRec = query.fetchCount();
		int offset = queryVo.getPage() * queryVo.getSize();
		query.offset(offset).limit(queryVo.getSize());
		List<AmountCalculation> list = query.fetch();
		List<AmountCalculationVo> resultList = new ArrayList<AmountCalculationVo>();
		if (list != null && list.size() > 0) {
			AmountCalculationVo vo = null;
			for (AmountCalculation entity : list) {
				vo = new AmountCalculationVo();
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
	public DataResponse<List<KeyValueVo>> getCalculations(AmountCalculationQueryVo queryVo) {
		DataResponse<List<KeyValueVo>> result = new DataResponse<List<KeyValueVo>>();
		JPAQuery<AmountCalculation> query = new JPAQuery<AmountCalculation>(em).from(qAmountCalculation);
		// 根据业务代码和模板代码查询
		if (!StringUtils.isEmpty(queryVo.getSysCode())) {
			query.where(qAmountCalculation.sysCode.eq(queryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
			query.where(qAmountCalculation.templateCode.eq(queryVo.getTemplateCode()));
		}

		// 根据id正序排列
		query.orderBy(qAmountCalculation.id.asc());
		List<AmountCalculation> list = query.fetch();
		List<KeyValueVo> vos = new ArrayList();
		if (!CollectionUtils.isEmpty(list)) {
			for (AmountCalculation item : list) {
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
	public DataResponse<AmountCalculationVo> detail(AmountCalculationQueryVo queryVo) {
		DataResponse<AmountCalculationVo> result = new DataResponse<AmountCalculationVo>();
		AmountCalculation entity = queryById(queryVo.getId());
		AmountCalculationVo vo = new AmountCalculationVo();
		BeanUtils.copyProperties(entity, vo);
		List<AmountCalculationItemVo> items = new ArrayList<>();
		if (!CollectionUtils.isEmpty(entity.getAmountCalculationItems())) {
			for (AmountCalculationItem item : entity.getAmountCalculationItems()
					) {
				AmountCalculationItemVo itemVo = new AmountCalculationItemVo();
				BeanUtils.copyProperties(item, itemVo);
				item.setId(IdUtil.getSnowFlakeStrId());
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
	public DataResponse add(AmountCalculationVo vo) {
		AmountCalculation entity = new AmountCalculation();
		BeanUtils.copyProperties(vo,entity);
		entity.setId(IdUtil.getSnowFlakeStrId());
		if (!CollectionUtils.isEmpty(vo.getItems())) {
			entity.setAmountCalculationItems(new ArrayList<AmountCalculationItem>());
			setItems(entity, vo);
		}
		em.persist(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse update(AmountCalculationVo vo) {
		AmountCalculation entity = queryById(vo.getId());
		BeanUtils.copyProperties(vo,entity);
        entity.getAmountCalculationItems().clear();
        if (!CollectionUtils.isEmpty(vo.getItems())) {
			setItems(entity, vo);
		}
		em.merge(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse delete(AmountCalculationDeleteVo deleteVo) {
		AmountCalculation entity = queryById(deleteVo.getId());
		em.remove(entity);
		return new DataResponse();
	}

	private AmountCalculation queryById(String id) {
		JPAQuery<AmountCalculation> query = new JPAQuery<AmountCalculation>(em).from(qAmountCalculation).where(qAmountCalculation.id.eq(id));
		AmountCalculation entity = query.fetchOne();
		return entity;
	}

	private void setItems(AmountCalculation entity, AmountCalculationVo vo) {
		for (AmountCalculationItemVo itemVo : vo.getItems()
				) {
			AmountCalculationItem item = new AmountCalculationItem();
			BeanUtils.copyProperties(itemVo, item);
			item.setId(IdUtil.getSnowFlakeStrId());
			entity.addAmountCalculationItem(item);
		}
	}
}
