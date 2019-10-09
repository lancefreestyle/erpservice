package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataPage;
import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.core.response.DataStatus;
import com.capgemini.cn.core.utils.IdUtil;
import com.capgemini.cn.erp.domain.*;
import com.capgemini.cn.erp.vo.*;
import com.capgemini.cn.erpmanage.service.ProductGroupService;
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
public class ProductGroupServiceImpl implements ProductGroupService {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    private EntityManager em;

    private QProductGroup qProductGroup = QProductGroup.productGroup;

    private QProductGroupItem qproductGroupItem = QProductGroupItem.productGroupItem;

    @Override
    public DataResponse<List<ProductGroupVo>> list(ProductGroupQueryVo queryVo) {
        DataResponse<List<ProductGroupVo>> result = new DataResponse<>();
        JPAQuery<ProductGroup> query = new JPAQuery<ProductGroup>(em).from(qProductGroup);
        if (!StringUtils.isEmpty(queryVo.getDescription())) {
            query.where(qProductGroup.Description.eq(queryVo.getDescription()));
        }
        /*Long totalRec = query.fetchCount();
        int offset = queryVo.getPage() * queryVo.getSize();
        query.offset(offset).limit(queryVo.getSize());*/
        List<ProductGroup> list = query.fetch();
        List<ProductGroupVo> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            ProductGroupVo vo = null;
            for (ProductGroup entity : list) {
                vo = new ProductGroupVo();
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
    public DataResponse add(ProductGroupVo vo) {
        ProductGroup entity = new ProductGroup();
        BeanUtils.copyProperties(vo,entity);
        entity.setId(IdUtil.getSnowFlakeStrId());
        List<ProductGroupItemVo> productGroupItemVos = vo.getItemVos();
        if(!CollectionUtils.isEmpty(productGroupItemVos)){
            entity.setProductGroupItem(new ArrayList<ProductGroupItem>());
            for(ProductGroupItemVo productGroupItemVo : productGroupItemVos){
                ProductGroupItem productGroupItem = new ProductGroupItem();
                BeanUtils.copyProperties(productGroupItemVo,productGroupItem);
                productGroupItem.setId(IdUtil.getSnowFlakeStrId());
                entity.addProductGroupItem(productGroupItem);
            }
        }
        em.persist(entity);
        return new DataResponse();
    }

    @Override
    @Transactional
    public DataResponse update(ProductGroupVo vo) {
        ProductGroup entity = queryById(vo.getId());
        BeanUtils.copyProperties(vo,entity);
        List<ProductGroupItemVo> productGroupItemVos = vo.getItemVos();
        if(!CollectionUtils.isEmpty(productGroupItemVos)){
            entity.getProductGroupItem().clear();
            for(ProductGroupItemVo productGroupItemVo : productGroupItemVos){
                ProductGroupItem productGroupItem = new ProductGroupItem();
                BeanUtils.copyProperties(productGroupItemVo,productGroupItem);
                productGroupItem.setId(IdUtil.getSnowFlakeStrId());
                entity.addProductGroupItem(productGroupItem);
            }
        }
        em.merge(entity);
        return new DataResponse();
    }

    @Override
    @Transactional
    public DataResponse delete(String id) {
        ProductGroup entity = queryById(id);
        em.remove(entity);
        return new DataResponse();
    }

    @Override
    public DataResponse deleteItem(String id) {
        com.capgemini.cn.erp.domain.ProductGroupItem productGroupItem = queryItemById(id);
        em.remove(productGroupItem);
        return new DataResponse();
    }

    @Override
    public DataResponse detailPage(ProductGroupItemQueryVo queryVo) {
        DataResponse<List<ProductGroupItemVo>> result = new DataResponse<>();
        JPAQuery<ProductGroupItem> query = new JPAQuery<ProductGroupItem>(em).from(qproductGroupItem);
        query.where(qproductGroupItem.productGroup.id.eq(queryVo.getId()));
        Long totalRec = query.fetchCount();
        int offset = queryVo.getPage() * queryVo.getSize();
        query.offset(offset).limit(queryVo.getSize());
        List<ProductGroupItem> list = query.fetch();
        List<ProductGroupItemVo> resultList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            ProductGroupItemVo vo = null;
            for (ProductGroupItem entity : list) {
                vo = new ProductGroupItemVo();
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

    private ProductGroup queryById(String id) {
        // TODO Auto-generated method stub
        JPAQuery<ProductGroup> query = new JPAQuery<ProductGroup>(em).from(qProductGroup).where(qProductGroup.id.eq(id));
        ProductGroup entity = query.fetchOne();
        return entity;
    }

    private ProductGroupItem queryItemById(String id) {
        // TODO Auto-generated method stub
        JPAQuery<ProductGroupItem> query = new JPAQuery<ProductGroupItem>(em).from(qproductGroupItem).where(qproductGroupItem.id.eq(id));
        ProductGroupItem entity = query.fetchOne();
        return entity;
    }

}
