package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.erp.domain.QRevenueShareDataEntity;
import com.capgemini.cn.erp.domain.RevenueShareDataEntity;
import com.capgemini.cn.erp.domain.RuleTypeEntity;
import com.capgemini.cn.erp.vo.RevenueShareDataVo;
import com.capgemini.cn.erpmanage.service.RevenueShareDataService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RevenueShareDataServiceImpl extends BaseService<QRevenueShareDataEntity, RevenueShareDataEntity>
        implements RevenueShareDataService {

    @Override
    public List<RevenueShareDataVo> allList() {
        List<RevenueShareDataEntity> list = super.selectAll();

        List<RevenueShareDataVo> listVo=new ArrayList<>();
        for (RevenueShareDataEntity dataEntity : list) {
            RevenueShareDataVo dataVo=new RevenueShareDataVo();
            BeanUtils.copyProperties(dataEntity,dataVo);
            listVo.add(dataVo);
        }

        return listVo;
    }


    @Override
    protected JPAQuery getJpaQuerySelectById(String id) {
        JPAQuery<RevenueShareDataEntity> queryObj = new JPAQuery<RevenueShareDataEntity>(em).from(getQuery()).where(getQuery().id.eq(id));
        return queryObj;
    }

    @Override
    public int add(RevenueShareDataEntity revenueShareDataEntity) {
        return 0;
    }

    @Override
    public int update(RevenueShareDataEntity revenueShareDataEntity) {
        return 0;
    }

    @Override
    protected QRevenueShareDataEntity setQueryObj() {
        return QRevenueShareDataEntity.revenueShareDataEntity;
    }
}
