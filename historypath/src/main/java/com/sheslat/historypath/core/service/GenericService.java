package com.sheslat.historypath.core.service;



import java.util.List;
import java.util.Optional;


public interface GenericService<T, K> {

    T create(T obj) throws Exception;

    T update(T obj) throws Exception;

    void delete(K id) throws Exception;

    List<T> findAll();

    Optional<T> findById(K id) throws Exception;

}
