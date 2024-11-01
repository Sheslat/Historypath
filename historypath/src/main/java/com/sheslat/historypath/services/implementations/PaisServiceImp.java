package com.sheslat.historypath.services.implementations;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.core.service.GenericServiceImp;
import com.sheslat.historypath.domain.Pais;
import com.sheslat.historypath.filters.PaisFilter;
import com.sheslat.historypath.services.interfaces.PaisService;
import com.sheslat.historypath.specification.PaisSpecifications;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaisServiceImp extends GenericServiceImp<Pais, Long> implements PaisService {


    public PaisServiceImp(GenericRepository<Pais, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Pais create(Pais obj) throws Exception {

        validatePais(obj);
        return repository.save(obj);
    }

    @Override
    @Transactional
    public Pais update(Pais obj) throws Exception {
        validatePais(obj);

        if (!repository.existsById(obj.getId())) {
            throw new EntityNotFoundException("El pais con id " + obj.getId() + " no existe");
        }
        return repository.save(obj);
    }


    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("El pais con id " + id + " no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public List<Pais> filterPais(PaisFilter filter) {
        Specification<Pais> specifications = PaisSpecifications.findByName(filter.getName());
        return repository.findAll(specifications);
    }

    private void validatePais(Pais obj) throws Exception {
        if (obj == null) {
            throw new Exception("El pais es nulo");
        }
        if (obj.getNombre() == null) {
            throw new Exception("El pais no tiene nombre");
        }
        if (obj.getDescripcion() == null) {
            throw new Exception("Es pais no tiene descripcion");
        }
        if (obj.getCultura() == null) {
            throw new Exception("El pais no tiene cultura");
        }
    }
}
