package com.sheslat.historypath.core.mapper;

import java.util.List;

public interface GenericMapper<E, D> {

    E toEntity(D dto) throws Exception;
    D toDto(E entity) throws Exception;
    List<D> toDtoList(List<E> entities);
    List<E> toEntityList(List<D> dtoList);
}
