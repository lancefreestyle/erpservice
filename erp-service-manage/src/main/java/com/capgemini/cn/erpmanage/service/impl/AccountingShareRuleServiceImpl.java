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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
            BeanUtils.copyProperties(ruleType,ruleTypeVo,"createDate","updateDate");
            ruleTypeVo.setCreateDate(ruleType.getCreateDate());
            ruleTypeVo.setUpdateDate(ruleType.getUpdateDate());



            BeanUtils.copyProperties(shareRuleEntity,shareRuleVo,"ruleTitle","ruleType", "beginDate", "endDate","createDate","updateDate");
            shareRuleVo.setRuleTitleVo(ruleTitleVo);
            shareRuleVo.setRuleTypeVo(ruleTypeVo);
            shareRuleVo.setBeginDate(DateUtil.toDay(shareRuleEntity.getBeginDate()));
            shareRuleVo.setEndDate(DateUtil.toDay(shareRuleEntity.getEndDate()));
            shareRuleVo.setCreateDate(shareRuleEntity.getCreateDate());
            shareRuleVo.setUpdateDate(shareRuleEntity.getUpdateDate());
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

    @Override
    @Transactional
    public DataResponse<String> save(AccountingShareRuleVo accountingShareRuleVo) {


        AccountingShareRuleEntity shareRuleEntity=new AccountingShareRuleEntity();
        shareRuleEntity.setId(accountingShareRuleVo.getId());
        shareRuleEntity.setShareType(accountingShareRuleVo.getShareType());
        shareRuleEntity.setBeginDate(Timestamp.valueOf(accountingShareRuleVo.getBeginDate()));
        shareRuleEntity.setEndDate(Timestamp.valueOf(accountingShareRuleVo.getEndDate()));
        shareRuleEntity.setDateFreq(accountingShareRuleVo.getDateFreq());
        shareRuleEntity.setFreqType(accountingShareRuleVo.getFreqType());
        shareRuleEntity.setCreateDate(accountingShareRuleVo.getCreateDate());
        shareRuleEntity.setUpdateDate(accountingShareRuleVo.getUpdateDate());

        RuleTitleVo ruleTitleVo = accountingShareRuleVo.getRuleTitleVo();
        RuleTypeVo ruleTypeVo = accountingShareRuleVo.getRuleTypeVo();
        RuleTitleEntity ruleTitleEntity=new RuleTitleEntity();

        ruleTitleEntity.setId(ruleTitleVo.getId());
        SystemBusinessTypeVo systemBusinessTypeVo = ruleTitleVo.getSystemBusinessTypeVo();
        BusinessTypeVo businessTypeVo = systemBusinessTypeVo.getBusinessTypeVo();
        SourceSystemVo sourceSystemVo = systemBusinessTypeVo.getSourceSystemVo();

        BusinessTypeEntity businessTypeEntity=new BusinessTypeEntity();
        SourceSystemEntity sourceSystemEntity=new SourceSystemEntity();
        BeanUtils.copyProperties(businessTypeVo,businessTypeEntity);
        BeanUtils.copyProperties(sourceSystemVo,sourceSystemEntity);



        SystemBusinessTypeEntity systemBusinessTypeEntity=new SystemBusinessTypeEntity();
        systemBusinessTypeEntity.setId(systemBusinessTypeVo.getId());
        systemBusinessTypeEntity.setBusinessTypeEntity(businessTypeEntity);
        systemBusinessTypeEntity.setSourceSystemEntity(sourceSystemEntity);

        ruleTitleEntity.setSystemBusinessType(systemBusinessTypeEntity);
        ruleTitleEntity.setId(ruleTitleVo.getId());


        DataTemplateVo dataTemplateVo = ruleTitleVo.getDataTemplateVo();
        DataTemplate dataTemplate=new DataTemplate();
        BeanUtils.copyProperties(dataTemplateVo,dataTemplate);


        ruleTitleEntity.setDataTemplate(dataTemplate);

        RuleTypeEntity ruleTypeEntity=new RuleTypeEntity();
        BeanUtils.copyProperties(ruleTypeVo,ruleTypeEntity);

        shareRuleEntity.setRuleTitle(ruleTitleEntity);
        shareRuleEntity.setRuleType(ruleTypeEntity);
        em.persist(shareRuleEntity);

        return new DataResponse<>();
    }
}
