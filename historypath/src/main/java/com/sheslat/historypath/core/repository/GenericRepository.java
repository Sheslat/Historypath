package com.sheslat.historypath.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, K> extends JpaRepository<T, K>, JpaSpecificationExecutor<T> {

}