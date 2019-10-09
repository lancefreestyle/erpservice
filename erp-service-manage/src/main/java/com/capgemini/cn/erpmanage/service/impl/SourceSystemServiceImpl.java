package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.*;
import com.capgemini.cn.erp.vo.BusinessTypeVo;
import com.capgemini.cn.erp.vo.SourceSystemVo;
import com.capgemini.cn.erp.vo.SystemBusinessTypeVo;
import com.capgemini.cn.erpmanage.service.SourceSystemService;
import com.google.common.collect.Lists;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SourceSystemServiceImpl implements SourceSystemService {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;


    private QSystemBusinessTypeEntity qSystemBusinessTypeEntity=QSystemBusinessTypeEntity.systemBusinessTypeEntity;

    @Override
    public DataResponse<List<SystemBusinessTypeVo>> alllist() {
        JPAQuery<SystemBusinessTypeEntity>  jpaQuery=new JPAQuery<SystemBusinessTypeEntity>(em).from(qSystemBusinessTypeEntity);
        jpaQuery.orderBy(qSystemBusinessTypeEntity.id.asc());
        List<SystemBusinessTypeVo> systemBusinessTypeVos = Lists.newArrayList();
        jpaQuery.fetch().forEach(entity -> {
            BusinessTypeEntity businessType = entity.getBusinessTypeEntity();
            SourceSystemEntity sourceSystem = entity.getSourceSystemEntity();
            SourceSystemVo sourceSystemVo = new SourceSystemVo(sourceSystem.getId(), sourceSystem.getSourceSystemCode(), sourceSystem.getSourceSystemName(), sourceSystem.getCreateDate(), sourceSystem.getUpdateDate());
            BusinessTypeVo businessTypeVo = new BusinessTypeVo(businessType.getId(), businessType.getBusinessTypeCode(), businessType.getBusinessTypeName(), businessType.getCreateDate(), businessType.getUpdateDate());
            SystemBusinessTypeVo systemBusinessTypeVo = new SystemBusinessTypeVo(entity.getId(), sourceSystemVo, businessTypeVo, entity.getCreateDate(), entity.getUpdateDate());
            systemBusinessTypeVos.add(systemBusinessTypeVo);
        });
        DataResponse<List<SystemBusinessTypeVo>> result=new DataResponse<>();
        result.setResponse(systemBusinessTypeVos);
        return result;
    }
}
