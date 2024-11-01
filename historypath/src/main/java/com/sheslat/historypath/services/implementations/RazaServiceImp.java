package com.sheslat.historypath.services.implementations;

import com.sheslat.historypath.core.repository.GenericRepository;
import com.sheslat.historypath.core.service.GenericServiceImp;
import com.sheslat.historypath.domain.Raza;
import com.sheslat.historypath.filters.RazaFilter;
import com.sheslat.historypath.services.interfaces.RazaService;
import com.sheslat.historypath.specification.RazaSpecifications;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RazaServiceImp extends GenericServiceImp<Raza, Long> implements RazaService {


    public RazaServiceImp(GenericRepository<Raza, Long> repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Raza create(Raza obj) throws Exception {

        validateRaza(obj);
        return repository.save(obj);
    }

    @Override
    @Transactional
    public Raza update(Raza obj) throws Exception {
        validateRaza(obj);

        if (!repository.existsById(obj.getId())) {
            throw new EntityNotFoundException("La raza con id " + obj.getId() + " no existe");
        }
        return repository.save(obj);

    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("La raza con id " + id + " no existe");
        }
        repository.deleteById(id);
    }


    public List<Raza> filterRaza(RazaFilter razaFilter) {
        Specification<Raza> specifications = RazaSpecifications.findByName(razaFilter.getName());
        return repository.findAll(specifications);
    }


    private void validateRaza(Raza obj) throws Exception {
        if (obj == null) {
            throw new Exception("La raza es nula");
        }
        if (obj.getNombre() == null) {
            throw new Exception("La raza no tiene nombre");
        }
        if (obj.getDescripcion() == null) {
            throw new Exception("La raza no tiene descripcion");
        }
    }
}
