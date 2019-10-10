package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.erp.domain.QRevenueSaleDataEntity;
import com.capgemini.cn.erp.domain.RevenueSaleDataEntity;
import com.capgemini.cn.erpmanage.service.RevenueSaleDataService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Service;

@Service
public class RevenueSaleDataServiceImpl extends BaseService<QRevenueSaleDataEntity, RevenueSaleDataEntity> implements RevenueSaleDataService {

    @Override
    protected JPAQuery getJpaQuerySelectById(String id) {
        JPAQuery<RevenueSaleDataEntity> query =
                new JPAQuery<RevenueSaleDataEntity>(em).from(getQuery()).where(getQuery().id.eq(id));
        return query;
    }

    @Override
    protected QRevenueSaleDataEntity setQueryObj() {
        return QRevenueSaleDataEntity.revenueSaleDataEntity;
    }
}
