package com.sheslat.historypath.filters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaisFilter {

    private Long id;

    private String name;

    private Long culturaId;
}
