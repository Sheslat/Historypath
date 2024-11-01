package com.sheslat.historypath.repository;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.domain.Cultura;
import org.springframework.stereotype.Repository;

@Repository
public interface CulturaRepository extends GenericRepository<Cultura, Long> {
}
