package com.sheslat.historypath.services.implementations;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.core.service.GenericServiceImp;
import com.sheslat.historypath.domain.Evento;
import com.sheslat.historypath.filters.EventoFilter;
import com.sheslat.historypath.services.interfaces.EventoService;
import com.sheslat.historypath.specification.EventoSpecifications;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoServiceImp extends GenericServiceImp<Evento, Long> implements EventoService {


    public EventoServiceImp(GenericRepository<Evento, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Evento create(Evento obj) throws Exception {
        validateEvento(obj);
        return repository.save(obj);
    }

    @Override
    @Transactional
    public Evento update(Evento obj) throws Exception {
        validateEvento(obj);
        if (!repository.existsById(obj.getId())) {
            throw new EntityNotFoundException("El evento con id " + obj.getId() + " no existe");
        }
        return repository.save(obj);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("El lugar con id " + id + " no existe");
        }
        repository.deleteById(id);
    }

    public List<Evento> filterEvento(EventoFilter eventoFilter) {
        Specification<Evento> specifications = EventoSpecifications.findByName(eventoFilter.getName());
        return repository.findAll(specifications);
    }


    private void validateEvento(Evento obj) throws Exception {
        if (obj == null) {
            throw new Exception("El evento es nulo");
        }
        if (obj.getNombre() == null) {
            throw new Exception("El evento no tiene nombre");
        }
        if (obj.getDescripcion() == null) {
            throw new Exception("El evento no tiene descripcion");
        }
        if (obj.getLugar() == null) {
            throw new Exception("El evento no tiene lugar");
        }
    }

}
