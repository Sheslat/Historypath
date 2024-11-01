package com.sheslat.historypath.services.interfaces;

import com.sheslat.historypath.core.service.GenericService;
import com.sheslat.historypath.domain.Bestia;
import com.sheslat.historypath.filters.BestiaFilter;

import java.util.List;

public interface BestiaService extends GenericService<Bestia, Long> {

    List<Bestia> filterBestia(BestiaFilter filter);

}
