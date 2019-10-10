package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.erp.domain.*;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.AccountingShareRuleService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountingShareRuleServiceImpl extends BaseService<QAccountingShareRuleEntity, AccountingShareRuleEntity> implements AccountingShareRuleService {

    @Override
    protected JPAQuery getJpaQuerySelectById(String id) {

        return null;
    }

    @Override
    protected QAccountingShareRuleEntity setQueryObj() {
        return QAccountingShareRuleEntity.accountingShareRuleEntity;
    }

    @Override
    public List<AccountingShareRuleVo> selectList() {

        List<AccountingShareRuleEntity> shareRuleEntities = super.selectAll();
        List<AccountingShareRuleVo> shareRuleVos=new ArrayList<>();
        for (AccountingShareRuleEntity shareRuleEntity : shareRuleEntities) {
            AccountingShareRuleVo shareRuleVo=new AccountingShareRuleVo();

            RuleTitleEntity ruleTitle = shareRuleEntity.getRuleTitle();
            RuleTypeEntity ruleType = shareRuleEntity.getRuleType();


            SystemBusinessTypeVo sbTypeVO=new SystemBusinessTypeVo();
            sbTypeVO.setId(ruleTitle.getSystemBusinessType().getId());

            DataTemplate dataTemplate = ruleTitle.getDataTemplate();

            BusinessTypeEntity businessTypeEntity = ruleTitle.getSystemBusinessType().getBusinessTypeEntity();
            SourceSystemEntity sourceSystemEntity = ruleTitle.getSystemBusinessType().getSourceSystemEntity();

            BusinessTypeVo businessTypeVo=new BusinessTypeVo();
            SourceSystemVo systemVo=new SourceSystemVo();
            BeanUtils.copyProperties(businessTypeEntity,businessTypeVo);
            BeanUtils.copyProperties(sourceSystemEntity,systemVo);

            sbTypeVO.setBusinessTypeVo(businessTypeVo);
            sbTypeVO.setSourceSystemVo(systemVo);

            DataTemplateVo templateVo=new DataTemplateVo();
            BeanUtils.copyProperties(dataTemplate,templateVo);

            RuleTitleVo ruleTitleVo =new RuleTitleVo();
            ruleTitleVo.setId(ruleTitle.getId());
            ruleTitleVo.setSystemBusinessTypeVo(sbTypeVO);
            ruleTitleVo.setDataTemplateVo(templateVo);
            RuleTypeVo ruleTypeVo=new RuleTypeVo();
            BeanUtils.copyProperties(ruleType,ruleTypeVo);



            BeanUtils.copyProperties(shareRuleEntity,shareRuleVo,"ruleTitle","ruleType");
            shareRuleVo.setRuleTitleVo(ruleTitleVo);
            shareRuleVo.setRuleTypeVo(ruleTypeVo);
            shareRuleVos.add(shareRuleVo);
        }
        return shareRuleVos;
    }
}