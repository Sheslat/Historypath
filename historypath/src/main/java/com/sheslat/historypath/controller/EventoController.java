package com.sheslat.historypath.controller;

import com.sheslat.historypath.domain.Evento;
import com.sheslat.historypath.dtos.EventoDto;
import com.sheslat.historypath.filters.EventoFilter;
import com.sheslat.historypath.mapper.EventoMapper;
import com.sheslat.historypath.services.interfaces.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("evento")
public class EventoController {

    private final EventoService eventoService;
    private final EventoMapper eventoMapper;

    @Autowired
    public EventoController(EventoService eventoService, EventoMapper eventoMapper){
        this.eventoService = eventoService;
        this.eventoMapper = eventoMapper;
    }

    @PostMapping
    public ResponseEntity<EventoDto> create(@RequestBody EventoDto dto) throws Exception {
        Evento evento = eventoMapper.toEntity(dto);
        Evento eventoCreado = eventoService.create(evento);
        return ResponseEntity.ok(eventoMapper.toDto(eventoCreado));
    }

    @PutMapping
    public ResponseEntity<EventoDto> update(@RequestBody EventoDto dto) throws Exception {
        Evento evento = eventoMapper.toEntity(dto);
        Evento eventoCreado = eventoService.update(evento);
        return ResponseEntity.ok(eventoMapper.toDto(eventoCreado));
    }

    @DeleteMapping("(id)")
    public ResponseEntity<EventoDto> delete(@RequestBody EventoDto dto) throws Exception {
        eventoService.delete(dto.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<EventoDto> find(@PathVariable Long id) throws Exception {
        Evento evento = eventoService.findById(id).orElseThrow(() -> new Exception("El evento de id " + id + " no existe"));
        return ResponseEntity.ok(eventoMapper.toDto(evento));
    }

    @GetMapping
    public ResponseEntity<List<EventoDto>> findAll()  {
        List<Evento> eventos = eventoService.findAll();
        return ResponseEntity.ok(eventoMapper.toDtoList(eventos));
    }

    @PostMapping("find")
    public ResponseEntity<List<EventoDto>> findFilter(@RequestBody EventoFilter filterDto)  {
        List<Evento> eventos = eventoService.filterEvento(filterDto).stream().toList();
        return ResponseEntity.ok(eventoMapper.toDtoList(eventos));
    }
}
