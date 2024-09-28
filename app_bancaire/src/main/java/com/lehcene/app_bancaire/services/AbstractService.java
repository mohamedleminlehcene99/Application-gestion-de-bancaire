package com.lehcene.app_bancaire.services;

import java.util.List;

public interface AbstractService <T>{

    Integer save(T t);
    List<T> findAll();
    T findById(Integer id);
    void delete(Integer id);
}
