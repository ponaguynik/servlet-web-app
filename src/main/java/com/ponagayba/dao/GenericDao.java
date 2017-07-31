package com.ponagayba.dao;

public interface GenericDao<T> {

    T create(T t);
    T update(T t);
    T delete(T t);
    T findById(T t);
}
