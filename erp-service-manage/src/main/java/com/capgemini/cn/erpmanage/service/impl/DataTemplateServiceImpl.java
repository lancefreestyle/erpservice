package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataPage;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.core.utils.IdUtil;
import com.capgemini.cn.erp.domain.DataTemplate;
import com.capgemini.cn.erp.domain.DataTemplateItem;
import com.capgemini.cn.erp.domain.QDataTemplate;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.DataTemplateService;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class DataTemplateServiceImpl implements DataTemplateService {

	@PersistenceContext(unitName = "baseEntityManagerFactory")
	private EntityManager em;

	private QDataTemplate qDataTemplate = QDataTemplate.dataTemplate;

	@Override
	@Transactional
	public DataResponse<List<DataTemplateVo>> list(DataTemplateQueryVo dataTemplateQueryVo) {
		DataResponse<List<DataTemplateVo>> result = new DataResponse<List<DataTemplateVo>>();
		JPAQuery<DataTemplate> query = new JPAQuery<DataTemplate>(em).from(qDataTemplate);
		if (!StringUtils.isEmpty(dataTemplateQueryVo.getSysCode())) {
			query.where(qDataTemplate.sysCode.eq(dataTemplateQueryVo.getSysCode()));
		}
		if (!StringUtils.isEmpty(dataTemplateQueryVo.getTemplateCode())) {
			query.where(qDataTemplate.templateCode.eq(dataTemplateQueryVo.getTemplateCode()));
		}

		Long totalRec = query.fetchCount();
		int offset = dataTemplateQueryVo.getPage() * dataTemplateQueryVo.getSize();
		query.offset(offset).limit(dataTemplateQueryVo.getSize());
		List<DataTemplate> list = query.fetch();
		List<DataTemplateVo> resultList = new ArrayList<DataTemplateVo>();
		if (list != null && list.size() > 0) {
			DataTemplateVo vo = null;
			for (DataTemplate entity : list) {
				vo = new DataTemplateVo();
				BeanUtils.copyProperties(entity, vo);
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
	public DataResponse<List<DataTemplateVo>> listAll() {
		DataResponse<List<DataTemplateVo>> result = new DataResponse<List<DataTemplateVo>>();
		JPAQuery<DataTemplate> query = new JPAQuery<DataTemplate>(em).from(qDataTemplate);
		List<DataTemplate> list = query.fetch();
		List<DataTemplateVo> resultList = new ArrayList<DataTemplateVo>();
		if (list != null && list.size() > 0) {
			DataTemplateVo vo = null;
			for (DataTemplate entity : list) {
				vo = new DataTemplateVo();
				BeanUtils.copyProperties(entity, vo);
				resultList.add(vo);
			}
		}
		result.setDataStatus(DataStatus.SUCCESS);
		result.setResponse(resultList);
		return result;
	}

	@Override
	@Transactional
	public DataResponse add(DataTemplateVo dataTemplateVo)
	{
		DataTemplate entity = new DataTemplate();
		BeanUtils.copyProperties(dataTemplateVo,entity);
		entity.setId(IdUtil.getSnowFlakeStrId());
		List<DataTemplateItemVo> dataTemplateItemVos = dataTemplateVo.getItems();
		if(!CollectionUtils.isEmpty(dataTemplateItemVos)){
			entity.setDataTemplateItems(new ArrayList<DataTemplateItem>());
			for(DataTemplateItemVo dataTemplateItemVo : dataTemplateItemVos){
				DataTemplateItem dataTemplateItem = new DataTemplateItem();
				BeanUtils.copyProperties(dataTemplateItemVo,dataTemplateItem);
				dataTemplateItem.setId(IdUtil.getSnowFlakeStrId());
				//dataTemplateItem.setDataTemplate(entity);
				entity.addDataTemplateItem(dataTemplateItem);
			}
		}
		em.persist(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse update(DataTemplateVo dataTemplateVo) {
		DataTemplate entity = queryById(dataTemplateVo.getId());
		BeanUtils.copyProperties(dataTemplateVo,entity);
		List<DataTemplateItemVo> dataTemplateItemVos = dataTemplateVo.getItems();
		if(!CollectionUtils.isEmpty(dataTemplateItemVos)){
			entity.getDataTemplateItems().clear();
			for(DataTemplateItemVo dataTemplateItemVo : dataTemplateItemVos){
				DataTemplateItem dataTemplateItem = new DataTemplateItem();
				BeanUtils.copyProperties(dataTemplateItemVo,dataTemplateItem);
				dataTemplateItem.setId(IdUtil.getSnowFlakeStrId());
				entity.addDataTemplateItem(dataTemplateItem);
			}
		}
		em.merge(entity);

		return new DataResponse();
	}

	private DataTemplate queryById(String id) {
		// TODO Auto-generated method stub
		JPAQuery<DataTemplate> query = new JPAQuery<DataTemplate>(em).from(qDataTemplate).where(qDataTemplate.id.eq(id));
		DataTemplate entity = query.fetchOne();
		return entity;
	}

	@Override
	@Transactional
	public DataResponse delete(String id) {
		DataTemplate entity = queryById(id);
		em.remove(entity);
		return new DataResponse();
	}

	@Override
	@Transactional
	public DataResponse<DataTemplateVo> detail(String id) {
		DataResponse<DataTemplateVo> result = new DataResponse<DataTemplateVo>();
		DataTemplate entity = queryById(id);
		DataTemplateVo dataTemplateVo = new DataTemplateVo();
		BeanUtils.copyProperties(entity,dataTemplateVo);
		List<DataTemplateItem> dataTemplateItems = entity.getDataTemplateItems();
		if(!CollectionUtils.isEmpty(dataTemplateItems)){
			List<DataTemplateItemVo> dataTemplateItemVos = new ArrayList<DataTemplateItemVo>();
			DataTemplateItemVo dataTemplateItemVo = null;
			for(DataTemplateItem dataTemplateItem : dataTemplateItems){
				dataTemplateItemVo = new DataTemplateItemVo();
				BeanUtils.copyProperties(dataTemplateItem,dataTemplateItemVo);
				dataTemplateItemVos.add(dataTemplateItemVo);
			}
			dataTemplateVo.setItems(dataTemplateItemVos);
		}
		result.setDataStatus(DataStatus.SUCCESS);
		result.setResponse(dataTemplateVo);
		return result;
	}


}
