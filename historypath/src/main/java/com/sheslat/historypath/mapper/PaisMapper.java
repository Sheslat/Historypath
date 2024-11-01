package com.sheslat.historypath.mapper;

import com.sheslat.historypath.core.mapper.GenericMapper;
import com.sheslat.historypath.domain.Pais;
import com.sheslat.historypath.dtos.PaisDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaisMapper extends GenericMapper<Pais, PaisDto> {
    @Mapping(source = "culturaId", target = "cultura.id")
    Pais toEntity(PaisDto dto);

    @Mapping(source = "cultura.id", target = "culturaId")
    PaisDto toDto(Pais entity);


}
