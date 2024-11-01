package com.sheslat.historypath.specification;

import com.sheslat.historypath.domain.Evento;
import org.springframework.data.jpa.domain.Specification;

public class EventoSpecifications {

    public static Specification<Evento> findById(Long id) {
        return (root, query, cb) -> {
            if (id == null) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.equal(root.get("id"), id);
        };
    }

    public static Specification<Evento> findByName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isEmpty()) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.like(root.get("nombre"), "%" + name + "%");
        };
    }
}
