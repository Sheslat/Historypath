package com.sheslat.historypath.repository;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.domain.Evento;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends GenericRepository<Evento, Long> {
}
