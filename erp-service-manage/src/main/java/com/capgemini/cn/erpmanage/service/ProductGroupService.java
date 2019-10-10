package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.ProductGroup;
import com.capgemini.cn.erp.domain.ProductGroupItem;
import com.capgemini.cn.erp.vo.ProductGroupItemQueryVo;
import com.capgemini.cn.erp.vo.ProductGroupQueryVo;
import com.capgemini.cn.erp.vo.ProductGroupVo;
import com.querydsl.jpa.impl.JPAQuery;

import java.util.List;

public interface ProductGroupService {

    DataResponse<List<ProductGroupVo>> list(ProductGroupQueryVo queryVo);

    DataResponse add(ProductGroupVo vo);

    DataResponse update(ProductGroupVo vo);

    DataResponse delete(String id);

    DataResponse deleteItem(String id);

    DataResponse detailPage(ProductGroupItemQueryVo queryVo);

    ProductGroup queryById(String id);

    ProductGroupItem queryItemById(String id);
}
