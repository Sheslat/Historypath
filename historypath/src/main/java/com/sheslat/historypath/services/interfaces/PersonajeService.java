package com.sheslat.historypath.services.interfaces;

import com.sheslat.historypath.core.service.GenericService;
import com.sheslat.historypath.domain.Personaje;
import com.sheslat.historypath.filters.PersonajeFilter;

import java.util.List;

public interface PersonajeService extends GenericService<Personaje, Long> {

    List<Personaje> filterPersonaje(PersonajeFilter filter);
}
