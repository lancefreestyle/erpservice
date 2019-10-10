package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.erp.domain.QRuleTitleEntity;
import com.capgemini.cn.erp.domain.RuleTitleEntity;
import com.capgemini.cn.erpmanage.service.RuleTitleService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Service;

@Service
public class RuleTitleServiceImpl extends BaseService<QRuleTitleEntity, RuleTitleEntity> implements RuleTitleService {
    @Override
    protected JPAQuery getJpaQuerySelectById(String id) {
        JPAQuery<RuleTitleEntity> query =
                new JPAQuery<RuleTitleEntity>(em).from(getQuery()).where(getQuery().id.eq(id));
        return query;
    }

    @Override
    protected QRuleTitleEntity setQueryObj() {
        return QRuleTitleEntity.ruleTitleEntity;
    }
}
