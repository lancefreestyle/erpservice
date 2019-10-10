package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.*;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.AccountingShareRuleService;
import com.capgemini.cn.erpmanage.util.DateUtil;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountingShareRuleServiceImpl extends BaseService<QAccountingShareRuleEntity, AccountingShareRuleEntity> implements AccountingShareRuleService {

    @Override
    protected JPAQuery getJpaQuerySelectById(String id) {
        JPAQuery<AccountingShareRuleEntity> query =
                new JPAQuery<AccountingShareRuleEntity>(em).from(getQuery()).where(getQuery().id.eq(id));
        return query;
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
            ruleTitleVo.setBeginDate(DateUtil.toDay(ruleTitle.getBeginDate()));
            ruleTitleVo.setEndDate(DateUtil.toDay(ruleTitle.getEndDate()));
            RuleTypeVo ruleTypeVo=new RuleTypeVo();
            BeanUtils.copyProperties(ruleType,ruleTypeVo);



            BeanUtils.copyProperties(shareRuleEntity,shareRuleVo,"ruleTitle","ruleType", "beginDate", "endDate");
            shareRuleVo.setRuleTitleVo(ruleTitleVo);
            shareRuleVo.setRuleTypeVo(ruleTypeVo);
            shareRuleVo.setBeginDate(DateUtil.toDay(shareRuleEntity.getBeginDate()));
            shareRuleVo.setEndDate(DateUtil.toDay(shareRuleEntity.getEndDate()));
            shareRuleVos.add(shareRuleVo);
        }
        return shareRuleVos;
    }

    @Override
    @Transactional
    public DataResponse<String> delete(String id) {
        AccountingShareRuleEntity shareRuleEntity = super.selectListById(id);
        em.remove(shareRuleEntity);
        return new DataResponse<>();
    }
}
