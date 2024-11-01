package com.sheslat.historypath.mapper;


import com.sheslat.historypath.core.mapper.GenericMapper;
import com.sheslat.historypath.domain.Raza;
import com.sheslat.historypath.dtos.RazaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RazaMapper extends GenericMapper<Raza,RazaDto> {

}
