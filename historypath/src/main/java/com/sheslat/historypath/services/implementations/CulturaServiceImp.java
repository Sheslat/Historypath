package com.sheslat.historypath.services.implementations;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.core.service.GenericServiceImp;
import com.sheslat.historypath.domain.Cultura;
import com.sheslat.historypath.filters.CulturaFilter;
import com.sheslat.historypath.services.interfaces.CulturaService;
import com.sheslat.historypath.specification.CulturaSpecifications;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CulturaServiceImp extends GenericServiceImp<Cultura, Long> implements CulturaService {


    public CulturaServiceImp(GenericRepository<Cultura, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Cultura create(Cultura obj) throws Exception {
        validateCultura(obj);
        return repository.save(obj);
    }

    @Override
    @Transactional
    public Cultura update(Cultura obj) throws Exception {
        validateCultura(obj);

        if (!repository.existsById(obj.getId())) {
            throw new EntityNotFoundException("La cultura con id " + obj.getId() + " no existe");
        }
        return repository.save(obj);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("La cultura con id " + id + " no existe");
        }
        repository.deleteById(id);
    }

    public List<Cultura> filterCultura(CulturaFilter filter) {
        Specification<Cultura> specifications = CulturaSpecifications.findByName(filter.getName());
        return repository.findAll(specifications);
    }


    private void validateCultura(Cultura obj) throws Exception {
        if (obj == null) {
            throw new Exception("La Cultura es nula");
        }
        if (obj.getNombre() == null) {
            throw new Exception("La Cultura no tiene nombre");
        }
        if (obj.getDescripcion() == null) {
            throw new Exception("La Cultura no tiene descripcion");
        }
    }

}
