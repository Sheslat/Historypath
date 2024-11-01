package com.sheslat.historypath.specification;

import com.sheslat.historypath.domain.Raza;
import org.springframework.data.jpa.domain.Specification;

public abstract class RazaSpecifications {

    public static Specification<Raza> findById(Long id) {
        return (root, query, cb) -> {
            if (id == null) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.equal(root.get("id"), id);
        };
    }

    public static Specification<Raza> findByName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isEmpty()) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.like(root.get("nombre"), "%"+name+"%");
        };
    }


}
