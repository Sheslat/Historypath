package com.sheslat.historypath.controller;

import com.sheslat.historypath.domain.Bestia;
import com.sheslat.historypath.dtos.BestiaDto;
import com.sheslat.historypath.filters.BestiaFilter;
import com.sheslat.historypath.mapper.BestiaMapper;
import com.sheslat.historypath.services.interfaces.BestiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bestia")
public class BestiaController {


    private final BestiaService bestiaService;
    private final BestiaMapper bestiaMapper;

    @Autowired
    public BestiaController(BestiaService bestiaService,BestiaMapper bestiaMapper){
        this.bestiaService = bestiaService;
        this.bestiaMapper = bestiaMapper;
    }

    @PostMapping
    public ResponseEntity<BestiaDto> create(@RequestBody BestiaDto dto) throws Exception {
        Bestia bestia = bestiaMapper.toEntity(dto);
        Bestia bestiaCreada = bestiaService.create(bestia);
        return ResponseEntity.ok(bestiaMapper.toDto(bestiaCreada));
    }

    @PutMapping
    public ResponseEntity<BestiaDto> update(@RequestBody BestiaDto dto) throws Exception {
        Bestia bestia = bestiaMapper.toEntity(dto);
        Bestia bestiaCreada = bestiaService.update(bestia);
        return ResponseEntity.ok(bestiaMapper.toDto(bestiaCreada));
    }

    @DeleteMapping("(id)")
    public ResponseEntity<BestiaDto> delete(@PathVariable long id) throws Exception {
        bestiaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<BestiaDto> find(@PathVariable long id) throws Exception {
        Bestia bestia = bestiaService.findById(id).orElseThrow(() -> new Exception("La bestia id " + id + " no existe"));
        return ResponseEntity.ok(bestiaMapper.toDto(bestia));
    }

    @GetMapping
    public ResponseEntity<List<BestiaDto>> findAll() {
        List<Bestia> bestias = bestiaService.findAll();
        return ResponseEntity.ok(bestiaMapper.toDtoList(bestias));
    }

    @PostMapping("find")
    public ResponseEntity<List<BestiaDto>> findFilter(@RequestBody BestiaFilter filterDto) {
        List<Bestia> bestias = bestiaService.filterBestia(filterDto).stream().toList();
        return ResponseEntity.ok(bestiaMapper.toDtoList(bestias));
    }
}
