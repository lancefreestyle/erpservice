package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataPage;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.core.utils.IdUtil;
import com.capgemini.cn.erp.domain.*;
import com.capgemini.cn.erp.vo.DataTemplateVo;
import com.capgemini.cn.erp.vo.ReconciliationRuleItemVo;
import com.capgemini.cn.erp.vo.ReconciliationRuleQueryVo;
import com.capgemini.cn.erp.vo.ReconciliationRuleVo;
import com.capgemini.cn.erpmanage.service.ReconciliationRuleService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
@Service
public class ReconciliationRuleServiceImpl implements ReconciliationRuleService {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;

    private QReconciliationRule qReconciliationRule = QReconciliationRule.reconciliationRule;

    private QReconciliationRuleItem qReconciliationRuleItem = QReconciliationRuleItem.reconciliationRuleItem;

    @Override
    public DataResponse list() {
        DataResponse<List<ReconciliationRuleVo>> result = new DataResponse<>();
        JPAQuery<ReconciliationRule> query = new JPAQuery<ReconciliationRule>(em).from(qReconciliationRule);
        List<ReconciliationRule> list = query.fetch();
        List<ReconciliationRuleVo> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            ReconciliationRuleVo vo = null;
            for (ReconciliationRule entity : list) {
                vo = new ReconciliationRuleVo();
                BeanUtils.copyProperties(entity, vo);
                resultList.add(vo);
            }
        }
        result.setDataStatus(DataStatus.SUCCESS);
        result.setResponse(resultList);
        return result;
    }

    @Override
    public DataResponse queryByRuleCode(ReconciliationRuleQueryVo queryVo) {
        DataResponse<List<ReconciliationRuleVo>> result = new DataResponse<>();
        JPAQuery<ReconciliationRule> query = new JPAQuery<ReconciliationRule>(em).from(qReconciliationRule);
        if (!StringUtils.isEmpty(queryVo.getRuleCode())) {
            query.where(qReconciliationRule.ruleCode.eq(queryVo.getRuleCode()));
        }
        Long totalRec = query.fetchCount();
        int offset = queryVo.getPage() * queryVo.getSize();
        query.offset(offset).limit(queryVo.getSize());
        List<ReconciliationRule> list = query.fetch();
        List<ReconciliationRuleVo> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            ReconciliationRuleVo vo = null;
            for (ReconciliationRule entity : list) {
                vo = new ReconciliationRuleVo();
                BeanUtils.copyProperties(entity, vo);
                resultList.add(vo);
                //开始查行
                JPAQuery<ReconciliationRuleItem> queryItem = new JPAQuery<ReconciliationRuleItem>(em)
                        .from(qReconciliationRuleItem);
                queryItem.where(qReconciliationRuleItem.reconciliationRule.id.eq(entity.getId()));
                List<ReconciliationRuleItem> itemList = queryItem.fetch();
                List<ReconciliationRuleItemVo> itemVos = new ArrayList<>();
                if (itemList != null && itemList.size() > 0) {
                    ReconciliationRuleItemVo itemVo = null;
                    for(ReconciliationRuleItem itemEntity : itemList){
                        itemVo = new ReconciliationRuleItemVo();
                        BeanUtils.copyProperties(itemEntity, itemVo);
                        itemVos.add(itemVo);
                    }
                }
                vo.setItemVos(itemVos);
            }
        }
        result.setDataStatus(DataStatus.SUCCESS);
        DataPage page = new DataPage();
        page.setTotalElements(totalRec);
        result.setPages(page);
        result.setResponse(resultList);
        return result;
    }

    @Override
    @Transactional
    public DataResponse add(ReconciliationRuleVo vo) {
        ReconciliationRule entity = new ReconciliationRule();
        BeanUtils.copyProperties(vo,entity);
        entity.setId(IdUtil.getSnowFlakeStrId());
        List<ReconciliationRuleItemVo> reconciliationRuleItemVos = vo.getItemVos();
        if(!CollectionUtils.isEmpty(reconciliationRuleItemVos)){
            entity.setReconciliationRuleItem(new ArrayList<ReconciliationRuleItem>());
            for(ReconciliationRuleItemVo reconciliationRuleItemVo : reconciliationRuleItemVos){
                ReconciliationRuleItem reconciliationRuleItem = new ReconciliationRuleItem();
                BeanUtils.copyProperties(reconciliationRuleItemVo,reconciliationRuleItem);
                reconciliationRuleItem.setId(IdUtil.getSnowFlakeStrId());
                entity.addReconciliationRuleItem(reconciliationRuleItem);
            }
        }
        em.persist(entity);
        return new DataResponse();
    }

    @Override
    @Transactional
    public DataResponse delete(String id) {
        ReconciliationRule entity = queryById(id);
        em.remove(entity);
        return new DataResponse();
    }

    private ReconciliationRule queryById(String id) {
        // TODO Auto-generated method stub
        JPAQuery<ReconciliationRule> query = new JPAQuery<ReconciliationRule>(em).from(qReconciliationRule).where(qReconciliationRule.id.eq(id));
        ReconciliationRule entity = query.fetchOne();
        return entity;
    }

}
