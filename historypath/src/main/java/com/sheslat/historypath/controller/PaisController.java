package com.sheslat.historypath.controller;


import com.sheslat.historypath.domain.Pais;
import com.sheslat.historypath.dtos.PaisDto;
import com.sheslat.historypath.filters.PaisFilter;
import com.sheslat.historypath.mapper.PaisMapper;
import com.sheslat.historypath.services.interfaces.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pais")
public class PaisController {


    private final PaisService paisService;
    private final PaisMapper paisMapper;

    @Autowired
    public PaisController(PaisService paisService, PaisMapper paisMapper){
        this.paisService = paisService;
        this.paisMapper = paisMapper;
    }

    @PostMapping
    public ResponseEntity<PaisDto> create(@RequestBody PaisDto dto) throws Exception {
        Pais pais = paisMapper.toEntity(dto);
        Pais paisCreado = paisService.create(pais);
        return ResponseEntity.ok(paisMapper.toDto(paisCreado));
    }

    @PutMapping("(id)")
    public ResponseEntity<PaisDto> update(@PathVariable Long id,@RequestBody PaisDto dto) throws Exception {
        Pais pais = paisMapper.toEntity(dto);
        Pais paisCreado = paisService.update(pais);
        return ResponseEntity.ok(paisMapper.toDto(paisCreado));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PaisDto> delete(@PathVariable Long id) throws Exception {
        paisService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<PaisDto> find(@PathVariable Long id) throws Exception {
        Pais pais = paisService.findById(id).orElseThrow(() -> new Exception("Pais con id " + id + " no existe"));
        return ResponseEntity.ok(paisMapper.toDto(pais));
    }

    @GetMapping
    public ResponseEntity<List<PaisDto>> findAll() {
        List<Pais> paises = paisService.findAll();
        return ResponseEntity.ok(paisMapper.toDtoList(paises));
    }

    @PostMapping("find")
    public ResponseEntity<List<PaisDto>> findFilter(@RequestBody PaisFilter filterDto) {
        List<Pais> paises = paisService.filterPais(filterDto).stream().toList();
        return ResponseEntity.ok(paisMapper.toDtoList(paises));
    }
}
