package com.sheslat.historypath.services.interfaces;

import com.sheslat.historypath.core.service.GenericService;
import com.sheslat.historypath.domain.Cultura;
import com.sheslat.historypath.filters.CulturaFilter;

import java.util.List;

public interface CulturaService extends GenericService<Cultura, Long> {

    List<Cultura> filterCultura(CulturaFilter filter);
}
