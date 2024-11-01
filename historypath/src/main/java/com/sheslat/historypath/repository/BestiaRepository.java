package com.sheslat.historypath.repository;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.domain.Bestia;
import org.springframework.stereotype.Repository;

@Repository
public interface BestiaRepository extends GenericRepository<Bestia, Long> {
}
