package com.sheslat.historypath.core.service;

import com.sheslat.historypath.core.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class GenericServiceImp<T, K> implements GenericService<T, K> {



    protected final GenericRepository<T, K> repository;

    @Autowired
    public GenericServiceImp(GenericRepository<T,K> repository){
        this.repository = repository;
    }

    @Override
    public T create(T entity) throws Exception {
        return repository.save(entity);
    }

    @Override
    public T update(T entity) throws Exception {
        return repository.save(entity);
    }

    @Override
    public void delete(K id) throws Exception {
        repository.deleteById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(K id) throws Exception {
        return repository.findById(id);
    }
}