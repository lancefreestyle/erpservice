package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.*;
import com.capgemini.cn.erpmanage.service.SourceSystemService;
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
    public DataResponse<List<SystemBusinessTypeEntity>> alllist() {
        DataResponse<List<SystemBusinessTypeEntity>> result=new DataResponse<>();
        JPAQuery<SystemBusinessTypeEntity>  jpaQuery=new JPAQuery<SystemBusinessTypeEntity>(em).from(qSystemBusinessTypeEntity);
        jpaQuery.orderBy(qSystemBusinessTypeEntity.id.asc());
        List<SystemBusinessTypeEntity> typeEntityList = jpaQuery.fetch();
//        for (SystemBusinessTypeEntity typeEntity : typeEntityList) {
//            System.out.println(typeEntity.getSourceSystemEntity().getSourceSystemName());
//            System.out.println(typeEntity.getBusinessTypeEntity().getBusinessTypeName());
//        }
        result.setResponse(typeEntityList);
        return result;
    }

    @Override
    public DataResponse<List<SourceSystemVo>> getConditions(SourceSystemVo queryVo) {
        return null;
    }
}
