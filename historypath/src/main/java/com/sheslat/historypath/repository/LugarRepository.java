package com.sheslat.historypath.repository;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.domain.Lugar;
import org.springframework.stereotype.Repository;

@Repository
public interface LugarRepository extends GenericRepository<Lugar, Long> {
}
