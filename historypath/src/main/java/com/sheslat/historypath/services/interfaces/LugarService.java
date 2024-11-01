package com.sheslat.historypath.services.interfaces;

import com.sheslat.historypath.core.service.GenericService;
import com.sheslat.historypath.domain.Lugar;
import com.sheslat.historypath.filters.LugarFilter;

import java.util.List;

public interface LugarService extends GenericService<Lugar, Long> {

    List<Lugar> filterLugar(LugarFilter filter);
}
