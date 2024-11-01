package com.sheslat.historypath.services.interfaces;

import com.sheslat.historypath.core.service.GenericService;
import com.sheslat.historypath.domain.Evento;
import com.sheslat.historypath.filters.EventoFilter;

import java.util.List;

public interface EventoService extends GenericService<Evento, Long> {

    List<Evento> filterEvento(EventoFilter filter);
}
