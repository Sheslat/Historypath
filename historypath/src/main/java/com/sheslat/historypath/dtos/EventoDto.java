package com.sheslat.historypath.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private LugarDto lugar;
}
