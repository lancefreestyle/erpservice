package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataPage;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.core.utils.IdUtil;
import com.capgemini.cn.erp.domain.*;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.PartnerGroupService;
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
public class PartnerGroupServiceImpl implements PartnerGroupService {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;

    private QPartnerGroup qPartnerGroup = QPartnerGroup.partnerGroup;

    private QPartnerGroupItem qPartnerGroupItem = QPartnerGroupItem.partnerGroupItem;

    @Override
    public DataResponse<List<PartnerGroupVo>> list(PartnerGroupQueryVo queryVo) {
        DataResponse<List<PartnerGroupVo>> result = new DataResponse<>();
        JPAQuery<PartnerGroup> query = new JPAQuery<PartnerGroup>(em).from(qPartnerGroup);
        if (!StringUtils.isEmpty(queryVo.getDescription())) {
            query.where(qPartnerGroup.Description.eq(queryVo.getDescription()));
        }
        /*Long totalRec = query.fetchCount();
        int offset = queryVo.getPage() * queryVo.getSize();
        query.offset(offset).limit(queryVo.getSize());*/
        List<PartnerGroup> list = query.fetch();
        List<PartnerGroupVo> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            PartnerGroupVo vo = null;
            for (PartnerGroup entity : list) {
                vo = new PartnerGroupVo();
                BeanUtils.copyProperties(entity, vo);
                resultList.add(vo);
            }
        }
        result.setDataStatus(DataStatus.SUCCESS);
        /*DataPage page = new DataPage();
        page.setTotalElements(totalRec);
        result.setPages(page);*/
        result.setResponse(resultList);
        return result;
    }

    @Override
    @Transactional
    public DataResponse add(PartnerGroupVo vo) {
        PartnerGroup entity = new PartnerGroup();
        BeanUtils.copyProperties(vo,entity);
        entity.setId(IdUtil.getSnowFlakeStrId());
        List<PartnerGroupItemVo> partnerGroupItemVos = vo.getItemVos();
        if(!CollectionUtils.isEmpty(partnerGroupItemVos)){
            entity.setPartnerGroupItem(new ArrayList<PartnerGroupItem>());
            for(PartnerGroupItemVo partnerGroupItemVo : partnerGroupItemVos){
                PartnerGroupItem partnerGroupItem = new PartnerGroupItem();
                BeanUtils.copyProperties(partnerGroupItemVo,partnerGroupItem);
                partnerGroupItem.setId(IdUtil.getSnowFlakeStrId());
                //dataTemplateItem.setDataTemplate(entity);
                entity.addPartnerGroupItem(partnerGroupItem);
            }
        }
        em.persist(entity);
        return new DataResponse();
    }

    @Override
    @Transactional
    public DataResponse update(PartnerGroupVo vo) {
        PartnerGroup entity = queryById(vo.getId());
        BeanUtils.copyProperties(vo,entity);
        List<PartnerGroupItemVo> partnerGroupItemVos = vo.getItemVos();
        if(!CollectionUtils.isEmpty(partnerGroupItemVos)){
            entity.getPartnerGroupItem().clear();
            for(PartnerGroupItemVo partnerGroupItemVo : partnerGroupItemVos){
                PartnerGroupItem partnerGroupItem = new PartnerGroupItem();
                BeanUtils.copyProperties(partnerGroupItemVo,partnerGroupItem);
                partnerGroupItem.setId(IdUtil.getSnowFlakeStrId());
                entity.addPartnerGroupItem(partnerGroupItem);
            }
        }
        em.merge(entity);
        return new DataResponse();
    }

    @Override
    @Transactional
    public DataResponse delete(String id) {
        PartnerGroup entity = queryById(id);
        em.remove(entity);
        return new DataResponse();
    }

    @Override
    public DataResponse deleteItem(String id) {
        PartnerGroupItem entity = queryItemById(id);
        em.remove(entity);
        return new DataResponse();
    }

    @Override
    public DataResponse detailPage(PartnerGroupItemQuerVo queryVo) {
        DataResponse<List<PartnerGroupItemVo>> result = new DataResponse<>();
        JPAQuery<PartnerGroupItem> query = new JPAQuery<PartnerGroupItem>(em).from(qPartnerGroupItem);
        query.where(qPartnerGroupItem.partnerGroup.id.eq(queryVo.getId()));
        Long totalRec = query.fetchCount();
        int offset = queryVo.getPage() * queryVo.getSize();
        query.offset(offset).limit(queryVo.getSize());
        List<PartnerGroupItem> list = query.fetch();
        List<PartnerGroupItemVo> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            PartnerGroupItemVo vo = null;
            for (PartnerGroupItem entity : list) {
                vo = new PartnerGroupItemVo();
                BeanUtils.copyProperties(entity, vo);
                resultList.add(vo);
            }
        }
        result.setDataStatus(DataStatus.SUCCESS);
        DataPage page = new DataPage();
        page.setTotalElements(totalRec);
        result.setPages(page);
        result.setResponse(resultList);
        return result;
    }

    private PartnerGroup queryById(String id) {
        // TODO Auto-generated method stub
        JPAQuery<PartnerGroup> query = new JPAQuery<PartnerGroup>(em).from(qPartnerGroup).where(qPartnerGroup.id.eq(id));
        PartnerGroup entity = query.fetchOne();
        return entity;
    }

    private PartnerGroupItem queryItemById(String id) {
        // TODO Auto-generated method stub
        JPAQuery<PartnerGroupItem> query = new JPAQuery<PartnerGroupItem>(em).from(qPartnerGroupItem).where(qPartnerGroupItem.id.eq(id));
        PartnerGroupItem entity = query.fetchOne();
        return entity;
    }
}
