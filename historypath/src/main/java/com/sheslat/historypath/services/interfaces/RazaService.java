package com.sheslat.historypath.services.interfaces;

import com.sheslat.historypath.domain.Raza;
import com.sheslat.historypath.core.service.GenericService;
import com.sheslat.historypath.filters.RazaFilter;


import java.util.List;

public interface RazaService extends GenericService<Raza,Long> {

    List<Raza> filterRaza(RazaFilter filter);
}
