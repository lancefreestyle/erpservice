package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.PartnerGroup;
import com.capgemini.cn.erp.domain.PartnerGroupItem;
import com.capgemini.cn.erp.domain.QPartnerGroupItem;
import com.capgemini.cn.erpmanage.service.PartnerGroupItemService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created By hongqi
 * Date:
 * Description:
 */
@Service
public class PartnerGroupItemImpl implements PartnerGroupItemService {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;

    private QPartnerGroupItem qPartnerGroupItem = QPartnerGroupItem.partnerGroupItem;

    @Override
    public DataResponse delete(String id) {
        PartnerGroupItem entity = queryById(id);
        em.remove(entity);
        return new DataResponse();
    }

    private PartnerGroupItem queryById(String id) {
        // TODO Auto-generated method stub
        JPAQuery<PartnerGroupItem> query = new JPAQuery<PartnerGroupItem>(em).from(qPartnerGroupItem).where(qPartnerGroupItem.id.eq(id));
        PartnerGroupItem entity = query.fetchOne();
        return entity;
    }
}
