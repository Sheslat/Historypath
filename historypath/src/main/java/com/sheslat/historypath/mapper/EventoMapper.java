package com.sheslat.historypath.mapper;

import com.sheslat.historypath.core.mapper.GenericMapper;
import com.sheslat.historypath.domain.Evento;
import com.sheslat.historypath.dtos.EventoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventoMapper extends GenericMapper<Evento, EventoDto> {
    //@Mapping(source = "lugarId", target = "lugar.id")
    Evento toEntity(EventoDto dto);

    //@Mapping(source = "lugar.id", target = "lugarId")
    EventoDto toDto(Evento entity);
}
