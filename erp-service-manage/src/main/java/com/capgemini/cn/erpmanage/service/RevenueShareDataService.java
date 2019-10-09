package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.erp.domain.RevenueShareDataEntity;
import com.capgemini.cn.erp.vo.RevenueShareDataVo;

import java.util.List;

public interface RevenueShareDataService extends IBaseService<RevenueShareDataEntity,String>{

    List<RevenueShareDataVo> allList();
}
