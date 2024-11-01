package com.sheslat.historypath.services.implementations;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.core.service.GenericServiceImp;
import com.sheslat.historypath.domain.Bestia;
import com.sheslat.historypath.filters.BestiaFilter;
import com.sheslat.historypath.services.interfaces.BestiaService;
import com.sheslat.historypath.specification.BestiaSpecifications;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BestiaServicioImp extends GenericServiceImp<Bestia, Long> implements BestiaService {


    public BestiaServicioImp(GenericRepository<Bestia, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Bestia create(Bestia obj) throws Exception {
        validateBestia(obj);
        return repository.save(obj);
    }

    @Override
    @Transactional
    public Bestia update(Bestia obj) throws Exception {
        validateBestia(obj);
        if (!repository.existsById(obj.getId())) {
            throw new EntityNotFoundException("La bestia con id " + obj.getId() + " no existe");
        }
        return repository.save(obj);

    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("La bestia con id " + id + " no existe");
        }
        repository.deleteById(id);
    }

    public List<Bestia> filterBestia(BestiaFilter filter) {
        Specification<Bestia> specifications = BestiaSpecifications.findByName(filter.getName());
        return repository.findAll(specifications);
    }


    private void validateBestia(Bestia obj) throws Exception {
        if (obj == null) {
            throw new Exception("La bestia es nula");
        }
        if (obj.getNombre() == null) {
            throw new Exception("La bestia no tiene nombre");
        }
        if (obj.getDescripcion() == null) {
            throw new Exception("La bestia no tiene descripcion");
        }
        if (obj.getPais() == null) {
            throw new Exception("La bestia no tiene pais");
        }
    }

}
