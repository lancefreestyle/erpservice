package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.ProductGroupItem;
import com.capgemini.cn.erp.domain.QProductGroupItem;
import com.capgemini.cn.erp.vo.ProductGroupItemVo;
import com.capgemini.cn.erpmanage.service.ProductGroupItemService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ProductGroupItemVo> selectList() {
        JPAQuery<ProductGroupItem> query = new JPAQuery<ProductGroupItem>(em).from(productGroupItem);
        query.orderBy(productGroupItem.id.asc());
        List<ProductGroupItemVo> productGroupItemVos=new ArrayList<>();
        List<ProductGroupItem> groupItems = query.fetch();
        for (ProductGroupItem groupItem : groupItems) {
            ProductGroupItemVo groupItemVo=new ProductGroupItemVo();
            BeanUtils.copyProperties(groupItem,groupItemVo,"productGroup");
            productGroupItemVos.add(groupItemVo);
        }
        return productGroupItemVos;
    }
}
