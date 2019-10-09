package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.ProductGroupItem;
import com.capgemini.cn.erp.domain.QProductGroupItem;
import com.capgemini.cn.erpmanage.service.ProductGroupItemService;
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
public class ProductGroupItemServiceImpl implements ProductGroupItemService {
    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;

    private QProductGroupItem productGroupItem = QProductGroupItem.productGroupItem;

    @Override
    public DataResponse delete(String id) {
        ProductGroupItem entity = queryItemById(id);
        em.remove(entity);
        return new DataResponse();
    }

    private ProductGroupItem queryItemById(String id) {
        // TODO Auto-generated method stub
        JPAQuery<ProductGroupItem> query = new JPAQuery<ProductGroupItem>(em).from(productGroupItem).where(productGroupItem.id.eq(id));
        ProductGroupItem entity = query.fetchOne();
        return entity;
    }
}
