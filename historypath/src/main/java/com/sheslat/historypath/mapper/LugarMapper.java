package com.sheslat.historypath.mapper;

import com.sheslat.historypath.core.mapper.GenericMapper;
import com.sheslat.historypath.domain.Lugar;
import com.sheslat.historypath.dtos.LugarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LugarMapper extends GenericMapper<Lugar, LugarDto> {

    //@Mapping(source = "paisId", target = "pais.id")
    Lugar toEntity(LugarDto dto);

    //@Mapping(source = "pais.id", target = "paisId")
    LugarDto toDto(Lugar entity);
}
