package com.sheslat.historypath.controller;

import com.sheslat.historypath.domain.Cultura;
import com.sheslat.historypath.dtos.CulturaDto;
import com.sheslat.historypath.filters.CulturaFilter;
import com.sheslat.historypath.mapper.CulturaMapper;
import com.sheslat.historypath.services.interfaces.CulturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cultura")
public class CulturaController {

    private final CulturaService culturaService;
    private final CulturaMapper culturaMapper;

    @Autowired
    public CulturaController(CulturaService culturaService,CulturaMapper culturaMapper){
        this.culturaService = culturaService;
        this.culturaMapper = culturaMapper;
    }

    @PostMapping
    public ResponseEntity<CulturaDto> create(@RequestBody CulturaDto dto) throws Exception {
        Cultura cultura = culturaMapper.toEntity(dto);
        Cultura culturaCreada = culturaService.create(cultura);
        return ResponseEntity.ok(culturaMapper.toDto(culturaCreada));
    }

    @PutMapping("{id}")
    public ResponseEntity<CulturaDto> update(@PathVariable Long id,@RequestBody CulturaDto dto) throws Exception {

        dto.setId(id);
        Cultura cultura = culturaMapper.toEntity(dto);
        Cultura culturaCreada = culturaService.update(cultura);
        return ResponseEntity.ok(culturaMapper.toDto(culturaCreada));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CulturaDto> delete(@PathVariable Long id) throws Exception {
        culturaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<CulturaDto> find(@PathVariable Long id) throws Exception {
        Cultura cultura = culturaService.findById(id).orElseThrow(() -> new Exception("La cultura con id " + id + " no existe"));
        return ResponseEntity.ok(culturaMapper.toDto(cultura));
    }

    @GetMapping
    public ResponseEntity<List<CulturaDto>> findAll()  {
        List<Cultura> culturas = culturaService.findAll();
        return ResponseEntity.ok(culturaMapper.toDtoList(culturas));
    }

    @PostMapping("find")
    public ResponseEntity<List<CulturaDto>> findFilter(@RequestBody CulturaFilter filterDto) {
        List<Cultura> culturas = culturaService.filterCultura(filterDto);
        return ResponseEntity.ok(culturaMapper.toDtoList(culturas));
    }
}
