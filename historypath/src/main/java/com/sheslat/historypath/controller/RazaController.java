package com.sheslat.historypath.controller;

import com.sheslat.historypath.domain.Raza;
import com.sheslat.historypath.dtos.PaisDto;
import com.sheslat.historypath.dtos.RazaDto;
import com.sheslat.historypath.mapper.RazaMapper;
import com.sheslat.historypath.services.interfaces.RazaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sheslat.historypath.filters.RazaFilter;

import java.util.List;

@RestController
@RequestMapping("raza")
public class RazaController {

    private final RazaService razaService;
    private final RazaMapper razaMapper;

    @Autowired
    public RazaController(RazaService razaService, RazaMapper razaMapper){
        this.razaService = razaService;
        this.razaMapper = razaMapper;
    }

    @PostMapping
    public ResponseEntity<RazaDto> create(@RequestBody RazaDto dto) throws Exception {
        Raza raza = razaMapper.toEntity(dto);
        Raza razaCreada = razaService.create(raza);
        return ResponseEntity.ok(razaMapper.toDto(razaCreada));
    }

    @PutMapping
    public ResponseEntity<RazaDto> update(@RequestBody RazaDto dto) throws Exception {
        Raza raza = razaMapper.toEntity(dto);
        Raza razaCreada = razaService.update(raza);
        return ResponseEntity.ok(razaMapper.toDto(razaCreada));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PaisDto> delete(@PathVariable Long id) throws Exception {
        razaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<RazaDto> find(@PathVariable Long id) throws Exception {
        Raza raza = razaService.findById(id).orElseThrow(()-> new Exception("La raza con id "+id+" no existe"));
        return ResponseEntity.ok(razaMapper.toDto(raza));
    }

    @GetMapping
    public ResponseEntity<List<RazaDto>> findAll() {
        List<Raza> razas = razaService.findAll();
       return ResponseEntity.ok(razaMapper.toDtoList(razas));
    }

    @PostMapping("find")
    public ResponseEntity<List<RazaDto>> findFilter(@RequestBody RazaFilter filterDto) {
        List<Raza> razas = razaService.filterRaza(filterDto);
        return ResponseEntity.ok(razaMapper.toDtoList(razas));
    }


}
