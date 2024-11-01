package com.sheslat.historypath.specification;

import com.sheslat.historypath.domain.Bestia;
import org.springframework.data.jpa.domain.Specification;

public class BestiaSpecifications {

    public static Specification<Bestia> findById(Long id) {
        return (root, query, cb) -> {
            if (id == null) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.equal(root.get("id"), id);
        };
    }

    public static Specification<Bestia> findByName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isEmpty()) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.like(root.get("nombre"), "%" + name + "%");
        };
    }

    public static Specification<Bestia> findByPais(Long paisId) {
        return (root, query, cb) -> {
            if (paisId == null) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.equal(root.join("pais").get("id"), paisId);
        };

    }

}
