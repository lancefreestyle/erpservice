package com.capgemini.cn.erpmanage.service;

import com.capgemini.cn.core.response.DataResponse;
import com.capgemini.cn.erp.domain.RuleTypeEntity;

import java.util.List;

public interface IBaseService<E,PK> {

    List<E> selectAll();

    E selectListById(PK id);

    int add(E e);

    int update(E e);
}
