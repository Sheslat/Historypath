package com.sheslat.historypath.services.implementations;


import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.core.service.GenericServiceImp;
import com.sheslat.historypath.domain.Personaje;
import com.sheslat.historypath.filters.PersonajeFilter;
import com.sheslat.historypath.services.interfaces.PersonajeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sheslat.historypath.specification.PersonajeSpecifications.*;

@Service
public class PersonajeServiceImp extends GenericServiceImp<Personaje, Long> implements PersonajeService {


    public PersonajeServiceImp(GenericRepository<Personaje, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Personaje create(Personaje obj) throws Exception {
        validatePersonaje(obj);
        return repository.save(obj);

    }

    @Override
    @Transactional
    public Personaje update(Personaje obj) throws Exception {
        validatePersonaje(obj);
        if (!repository.existsById(obj.getId())) {
            throw new EntityNotFoundException("El personaje con id " + obj.getId() + " no existe");
        }
        return repository.save(obj);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("El personaje con id " + id + " no existe");
        }
        repository.deleteById(id);
    }


    public List<Personaje> filterPersonaje(PersonajeFilter filter) {
        Specification<Personaje> specifications = findByName(filter.getName()).and(findByRaza(filter.getRazaId()).and(findByLugar(filter.getLugarId())));
        return repository.findAll(specifications);
    }


    private void validatePersonaje(Personaje obj) throws Exception {
        if (obj == null) {
            throw new Exception("El personaje es nulo");
        }
        if (obj.getNombre() == null) {
            throw new Exception("El personaje no tiene nombre");
        }
        if (obj.getDescripcion() == null) {
            throw new Exception("El personaje no tiene descripcion");
        }
        if (obj.getEdad() == null) {
            throw new Exception("El personaje no tiene edad");
        }
        if (obj.getRaza() == null) {
            throw new Exception("El personaje no tiene raza");
        }
        if (obj.getLugarOrigen() == null) {
            throw new Exception("El personaje no tiene lugar de origen");
        }
    }

}
