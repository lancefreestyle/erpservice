package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.PartnerGroupItem;
import com.capgemini.cn.erp.domain.QRuleTypeEntity;
import com.capgemini.cn.erp.domain.RuleTypeEntity;
import com.capgemini.cn.erp.vo.RuleTypeVo;
import com.capgemini.cn.erpmanage.service.RuleTypeService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RuleTypeServiceImpl extends BaseService<QRuleTypeEntity, RuleTypeEntity>  implements RuleTypeService {

    @Override
    public List<RuleTypeVo> allList() {
        List<RuleTypeEntity> ruleTypeEntities = super.selectAll();
        List<RuleTypeVo> ruleTypeVoList=new ArrayList<>();
        for (RuleTypeEntity ruleTypeEntity : ruleTypeEntities) {
            RuleTypeVo ruleTypeVo=new RuleTypeVo();
            BeanUtils.copyProperties(ruleTypeEntity,ruleTypeVo);
            ruleTypeVoList.add(ruleTypeVo);
        }
        return ruleTypeVoList;
    }

    @Override
    protected JPAQuery getJpaQuerySelectById(String id) {
        JPAQuery<RuleTypeEntity> query = new JPAQuery<RuleTypeEntity>(em).from(getQuery()).where(getQuery().id.eq(id));
        return query;
    }

    @Override
    public int add(RuleTypeEntity ruleTypeEntity) {
        return 0;
    }

    @Override
    public int update(RuleTypeEntity ruleTypeEntity) {
        return 0;
    }

    @Override
    protected QRuleTypeEntity setQueryObj() {
        return QRuleTypeEntity.ruleTypeEntity;
    }
}
