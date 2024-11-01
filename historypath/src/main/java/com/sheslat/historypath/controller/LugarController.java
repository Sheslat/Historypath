package com.sheslat.historypath.controller;

import com.sheslat.historypath.domain.Lugar;
import com.sheslat.historypath.dtos.LugarDto;
import com.sheslat.historypath.filters.LugarFilter;
import com.sheslat.historypath.mapper.LugarMapper;
import com.sheslat.historypath.services.interfaces.LugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lugar")
public class LugarController {


    private final LugarService lugarService;
    private final LugarMapper lugarMapper;

    @Autowired
    public LugarController(LugarService lugarService, LugarMapper lugarMapper){
        this.lugarService = lugarService;
        this.lugarMapper = lugarMapper;
    }

    @PostMapping
    public ResponseEntity<LugarDto> create(@RequestBody LugarDto dto) throws Exception {
        Lugar lugar = lugarMapper.toEntity(dto);
        Lugar lugarCreado = lugarService.create(lugar);
        return ResponseEntity.ok(lugarMapper.toDto(lugarCreado));
    }

    @PutMapping
    public ResponseEntity<LugarDto> update(@RequestBody LugarDto dto) throws Exception {
        Lugar lugar = lugarMapper.toEntity(dto);
        Lugar lugarCreado = lugarService.update(lugar);
        return ResponseEntity.ok(lugarMapper.toDto(lugarCreado));
    }

    @DeleteMapping("(id)")
    public ResponseEntity<LugarDto> delete(@RequestBody LugarDto dto) throws Exception {
        lugarService.delete(dto.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<LugarDto> find(@PathVariable long id) throws Exception {
        Lugar lugar = lugarService.findById(id).orElseThrow(()-> new Exception("El lugar con id "+id+" no existe"));
        return ResponseEntity.ok(lugarMapper.toDto(lugar));
    }

    @GetMapping
    public ResponseEntity<List<LugarDto>> findAll() {
        List<Lugar> lugares = lugarService.findAll();
        return ResponseEntity.ok(lugarMapper.toDtoList(lugares));
    }

    @PostMapping("find")
    public ResponseEntity<List<LugarDto>> findFilter(@RequestBody LugarFilter filterDto) {
        List<Lugar> lugares = lugarService.filterLugar(filterDto).stream().toList();
        return ResponseEntity.ok(lugarMapper.toDtoList(lugares));
    }
}
