package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.ProductGroupItem;
import com.capgemini.cn.erp.vo.ProductGroupItemVo;

import java.util.List;

public interface ProductGroupItemService {

    DataResponse delete(String id);

    List<ProductGroupItemVo> selectList();
}
