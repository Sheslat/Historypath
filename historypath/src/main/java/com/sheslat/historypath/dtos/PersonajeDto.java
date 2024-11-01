package com.sheslat.historypath.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonajeDto {
    private Long id;
    private String nombre;
    private Long edad;
    private Long razaId;
    private String descripcion;
    private Long lugarId;
}
