package com.sheslat.historypath.filters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventoFilter {

    private Long id;

    private String name;

    private Long lugarId;
}
