package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.core.response.DataResponse;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BaseService<T extends EntityPathBase,E> {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    protected EntityManager em;

    private T query;

    protected DataResponse<List<E>> selectAll(){

        DataResponse<List<E>> result=new DataResponse<>();
        JPAQuery<E> jpaQuery=new JPAQuery<E>(em).from(query);
        List<E> entityList = jpaQuery.fetch();
        result.setResponse(entityList);
        return result;

    }

    public void setQuery(T query) {
        this.query = query;
    }
}
