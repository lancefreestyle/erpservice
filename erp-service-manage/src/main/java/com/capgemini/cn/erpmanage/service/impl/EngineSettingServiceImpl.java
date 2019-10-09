package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataPage;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.core.utils.IdUtil;
import com.capgemini.cn.core.utils.StringUtil;
import com.capgemini.cn.erp.domain.EngineSetting;
import com.capgemini.cn.erp.domain.EngineSettingItem;
import com.capgemini.cn.erp.domain.QEngineSetting;
import com.capgemini.cn.erp.vo.EngineSettingDeleteVo;
import com.capgemini.cn.erp.vo.EngineSettingItemVo;
import com.capgemini.cn.erp.vo.EngineSettingQueryVo;
import com.capgemini.cn.erp.vo.EngineSettingVo;
import com.capgemini.cn.erpmanage.service.EngineSettingService;
import com.querydsl.jpa.impl.JPAQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EngineSettingServiceImpl implements EngineSettingService {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private QEngineSetting qEngineSetting = QEngineSetting.engineSetting;

    @Override
    public DataResponse<List<EngineSettingVo>> list(EngineSettingQueryVo queryVo) {
        // 返回的结果使用AlarmContactVo实例
        DataResponse<List<EngineSettingVo>> result = new DataResponse<List<EngineSettingVo>>();
        JPAQuery<EngineSetting> query = new JPAQuery<EngineSetting>(em).from(qEngineSetting);
        // 根据业务代码和模板代码查询
        if (!StringUtils.isEmpty(queryVo.getSysCode())) {
            query.where(qEngineSetting.sysCode.eq(queryVo.getSysCode()));
        }
        if (!StringUtils.isEmpty(queryVo.getTemplateCode())) {
            query.where(qEngineSetting.templateCode.eq(queryVo.getTemplateCode()));
        }

        // 根据id正序排列
        query.orderBy(qEngineSetting.id.asc());

        Long totalRec = query.fetchCount();
        int offset = queryVo.getPage() * queryVo.getSize();
        query.offset(offset).limit(queryVo.getSize());
        List<EngineSetting> list = query.fetch();
        List<EngineSettingVo> resultList = new ArrayList<EngineSettingVo>();
        if (list != null && list.size() > 0) {
            EngineSettingVo vo = null;
            for (EngineSetting entity : list) {
                vo = new EngineSettingVo();
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
    public DataResponse<EngineSettingVo> detail(EngineSettingQueryVo queryVo) {
        DataResponse<EngineSettingVo> result = new DataResponse<EngineSettingVo>();
        EngineSetting entity = queryById(queryVo.getId());
        EngineSettingVo vo = new EngineSettingVo();
        BeanUtils.copyProperties(entity, vo);
        List<EngineSettingItemVo> items = new ArrayList<>();
        if (!CollectionUtils.isEmpty(entity.getEngineSettingItems())) {
            for (EngineSettingItem item : entity.getEngineSettingItems()
            ) {
                EngineSettingItemVo itemVo = new EngineSettingItemVo();
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
    public DataResponse add(EngineSettingVo vo) {
        EngineSetting entity = new EngineSetting();
        BeanUtils.copyProperties(vo,entity);
        entity.setId(IdUtil.getSnowFlakeStrId());
        processDate(entity, vo);
        if (!CollectionUtils.isEmpty(vo.getItems())) {
            entity.setEngineSettingItems(new ArrayList<>());
            setItems(entity, vo);
        }
        em.persist(entity);
        return new DataResponse();
    }

    @Override
    @Transactional
    public DataResponse update(EngineSettingVo vo) {
        EngineSetting entity = queryById(vo.getId());
        BeanUtils.copyProperties(vo,entity);
        processDate(entity, vo);
        if (!CollectionUtils.isEmpty(vo.getItems())) {
            entity.getEngineSettingItems().clear();
            setItems(entity, vo);
        }
        em.merge(entity);
        return new DataResponse();
    }

    @Override
    @Transactional
    public DataResponse delete(EngineSettingDeleteVo deleteVo) {
        EngineSetting entity = queryById(deleteVo.getId());
        em.remove(entity);
        return new DataResponse();
    }

    private EngineSetting queryById(String id) {
        JPAQuery<EngineSetting> query = new JPAQuery<EngineSetting>(em).from(qEngineSetting).where(qEngineSetting.id.eq(id));
        EngineSetting entity = query.fetchOne();
        return entity;
    }

    private void processDate(EngineSetting entity, EngineSettingVo vo) {
        try {
            if (StringUtil.isNotBlank(vo.getEnableDate())) {
                entity.setEnableDate(sdf.parse(vo.getEnableDate()));
            }
            if (StringUtil.isNotBlank(vo.getInvalidDate())) {
                entity.setInvalidDate(sdf.parse(vo.getInvalidDate()));
            }
        } catch (ParseException e) {
        }
    }

    private void setItems(EngineSetting entity, EngineSettingVo vo) {
        for (EngineSettingItemVo itemVo : vo.getItems()
        ) {
            EngineSettingItem item = new EngineSettingItem();
            BeanUtils.copyProperties(itemVo, item);
            item.setId(IdUtil.getSnowFlakeStrId());
            entity.addEngineSettingItem(item);
        }
    }

}
