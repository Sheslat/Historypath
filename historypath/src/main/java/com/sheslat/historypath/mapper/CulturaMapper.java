package com.sheslat.historypath.mapper;

import com.sheslat.historypath.core.mapper.GenericMapper;
import com.sheslat.historypath.domain.Cultura;
import com.sheslat.historypath.dtos.CulturaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CulturaMapper extends GenericMapper< Cultura,CulturaDto> {

}
