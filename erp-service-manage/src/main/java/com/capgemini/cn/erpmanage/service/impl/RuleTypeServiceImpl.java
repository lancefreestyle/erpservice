package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.QRuleTypeEntity;
import com.capgemini.cn.erp.domain.RuleTypeEntity;
import com.capgemini.cn.erpmanage.service.RuleTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleTypeServiceImpl extends BaseService<QRuleTypeEntity, RuleTypeEntity> implements RuleTypeService {

    @Override
    public DataResponse<List<RuleTypeEntity>> allList() {
        setQuery(QRuleTypeEntity.ruleTypeEntity);
        return super.selectAll();
    }
}
