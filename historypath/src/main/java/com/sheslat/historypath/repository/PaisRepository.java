package com.sheslat.historypath.repository;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.domain.Pais;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends GenericRepository<Pais, Long> {
}
