package com.sheslat.historypath.services.interfaces;

import com.sheslat.historypath.domain.Pais;
import com.sheslat.historypath.core.service.GenericService;
import com.sheslat.historypath.filters.PaisFilter;

import java.util.List;

public interface PaisService extends GenericService<Pais, Long> {

    List<Pais> filterPais(PaisFilter filter);
}
