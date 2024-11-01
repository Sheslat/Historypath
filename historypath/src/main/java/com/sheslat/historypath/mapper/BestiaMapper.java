package com.sheslat.historypath.mapper;


import com.sheslat.historypath.core.mapper.GenericMapper;
import com.sheslat.historypath.domain.Bestia;
import com.sheslat.historypath.dtos.BestiaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BestiaMapper extends GenericMapper<Bestia, BestiaDto> {
    @Mapping(source = "paisId", target = "pais.id")
    Bestia toEntity(BestiaDto dto);

    @Mapping(source = "pais.id", target = "paisId")
    BestiaDto toDto(Bestia entity);


}
