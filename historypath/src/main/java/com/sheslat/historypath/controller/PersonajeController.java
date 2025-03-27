package com.sheslat.historypath.controller;

import com.sheslat.historypath.domain.Personaje;
import com.sheslat.historypath.dtos.PersonajeDto;
import com.sheslat.historypath.filters.PersonajeFilter;
import com.sheslat.historypath.mapper.PersonajeMapper;
import com.sheslat.historypath.services.interfaces.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personaje")
public class PersonajeController {


    private final PersonajeService personajeService;
    private final PersonajeMapper personajeMapper;

    @Autowired
    public PersonajeController(PersonajeService personajeService, PersonajeMapper personajeMapper){
        this.personajeService = personajeService;
        this.personajeMapper = personajeMapper;
    }

    @PostMapping
    public ResponseEntity<PersonajeDto> create(@RequestBody PersonajeDto dto) throws Exception {
        Personaje personaje = personajeMapper.toEntity(dto);
        Personaje personajeCreado = personajeService.create(personaje);
        return ResponseEntity.ok(personajeMapper.toDto(personajeCreado));
    }

    @PutMapping("(id)")
    public ResponseEntity<PersonajeDto> update(@PathVariable Long id,@RequestBody PersonajeDto dto) throws Exception {
        Personaje personaje = personajeMapper.toEntity(dto);
        Personaje personajeCreado = personajeService.update(personaje);
        return ResponseEntity.ok(personajeMapper.toDto(personajeCreado));
    }

    @DeleteMapping("(id)")
    public ResponseEntity<PersonajeDto> delete(@RequestBody PersonajeDto dto) throws Exception {
        personajeService.delete(dto.getId());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonajeDto> find(@PathVariable long id) throws Exception {
        Personaje personaje = personajeService.findById(id).orElseThrow(() -> new Exception("Personaje con id " + id + " no existe"));
        return ResponseEntity.ok(personajeMapper.toDto(personaje));
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDto>> findAll() {
        List<Personaje> personajes = personajeService.findAll();
        return ResponseEntity.ok(personajeMapper.toDtoList(personajes));
    }

    @PostMapping("find")
    public ResponseEntity<List<PersonajeDto>> findFilter(@RequestBody PersonajeFilter filterDto) {
        List<Personaje> personajes = personajeService.filterPersonaje(filterDto).stream().toList();
        return ResponseEntity.ok(personajeMapper.toDtoList(personajes));
    }


}
