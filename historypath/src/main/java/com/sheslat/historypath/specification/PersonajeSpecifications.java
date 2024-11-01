package com.sheslat.historypath.specification;

import com.sheslat.historypath.domain.Personaje;
import org.springframework.data.jpa.domain.Specification;

public class PersonajeSpecifications {

    public static Specification<Personaje> findById(Long id) {
        return (root, query, cb) -> {
            if (id == null) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.equal(root.get("id"), id);
        };
    }

    public static Specification<Personaje> findByName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isEmpty()) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.like(root.get("nombre"), "%" + name + "%");
        };
    }

    public static Specification<Personaje> findByRaza(Long razaId) {
        return (root, query, cb) -> {
            if (razaId == null || razaId <= 0) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.equal(root.get("raza").get("id"),  razaId );
        };
    }

    public static Specification<Personaje> findByLugar(Long lugar) {
        return (root, query, cb) -> {
            if (lugar == null || lugar <= 0) {
                return cb.conjunction(); // Return all if no name is provided
            }
            return cb.equal(root.get("lugarOrigen").get("id"),  lugar );
        };
    }


}
