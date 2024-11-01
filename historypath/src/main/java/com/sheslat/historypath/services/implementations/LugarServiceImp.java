package com.sheslat.historypath.services.implementations;


import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.core.service.GenericServiceImp;
import com.sheslat.historypath.domain.Lugar;
import com.sheslat.historypath.filters.LugarFilter;
import com.sheslat.historypath.services.interfaces.LugarService;
import com.sheslat.historypath.specification.LugarSpecifications;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LugarServiceImp extends GenericServiceImp<Lugar, Long> implements LugarService {


    public LugarServiceImp(GenericRepository<Lugar, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Lugar create(Lugar obj) throws Exception {
        validateLugar(obj);
        return repository.save(obj);
    }

    @Override
    @Transactional
    public Lugar update(Lugar obj) throws Exception {
        validateLugar(obj);
        if (!repository.existsById(obj.getId())) {
            throw new EntityNotFoundException("El lugar con id " + obj.getId() + " no existe");
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

    public List<Lugar> filterLugar(LugarFilter filter) {
        Specification<Lugar> specifications = LugarSpecifications.findByName(filter.getName());
        return repository.findAll(specifications);
    }


    private void validateLugar(Lugar obj) throws Exception {
        if (obj == null) {
            throw new Exception("El lugar es nulo");
        }
        if (obj.getNombre() == null) {
            throw new Exception("El lugar no tiene nombre");
        }
        if (obj.getDescripcion() == null) {
            throw new Exception("El lugar no tiene descripcion");
        }
    }

}
