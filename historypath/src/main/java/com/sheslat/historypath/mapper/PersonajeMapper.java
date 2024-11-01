package com.sheslat.historypath.mapper;

import com.sheslat.historypath.core.mapper.GenericMapper;
import com.sheslat.historypath.domain.Personaje;
import com.sheslat.historypath.dtos.PersonajeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonajeMapper extends GenericMapper<Personaje, PersonajeDto> {
    @Mapping(source = "lugarId", target = "lugarOrigen.id")
    @Mapping(source = "razaId", target = "raza.id")
    Personaje toEntity(PersonajeDto dto);

    @Mapping(source = "lugarOrigen.id", target = "lugarId")
    @Mapping(source = "raza.id", target = "razaId")
    PersonajeDto toDto(Personaje entity);
}
