package com.capgemini.cn.erpmanage.service.impl;

import com.capgemini.cn.erpmanage.service.IBaseService;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class BaseService<T extends EntityPathBase<E>, E> implements IBaseService<E, String> {

    @PersistenceContext(unitName = "baseEntityManagerFactory")
    protected EntityManager em;

    private T query;

    @Override
    public List<E> selectAll() {
        initQueryObj();
        JPAQuery<E> jpaQuery = new JPAQuery<E>(em).from(query);
        List<E> entityList = jpaQuery.fetch();
        return entityList;

    }

    @Override
    public E selectListById(String id) {
        initQueryObj();
        JPAQuery jpaQuerySelectById = getJpaQuerySelectById(id);
        return (E) jpaQuerySelectById.fetchOne();
    }

    @Override
    public int add(E e) {

        em.persist(e);
        return 0;
    }

    @Override
    public int update(E e) {
        em.merge(e);
        return 0;
    }


    protected void initQueryObj() {
        query = setQueryObj();
    }

    protected abstract JPAQuery getJpaQuerySelectById(String id);

    protected abstract T setQueryObj();

    public T getQuery() {
        return query;
    }
}
