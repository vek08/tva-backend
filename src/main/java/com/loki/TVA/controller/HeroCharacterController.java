package com.loki.TVA.controller;

import com.loki.TVA.dto.HeroCharacterRequestDTO;
import com.loki.TVA.dto.HeroCharacterResponseDTO;
import com.loki.TVA.service.HeroCharacterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hero")
public class HeroCharacterController {

    @Autowired
    private HeroCharacterService service;

    //get all hero
    @GetMapping
    public ResponseEntity<List<HeroCharacterResponseDTO>> getAllHero() {
        List<HeroCharacterResponseDTO> hero = service.getAllHero();
        return ResponseEntity.ok(hero);
    }

    //get hero by id
    @GetMapping("/{id}")
    public ResponseEntity<HeroCharacterResponseDTO> getHeroById(@PathVariable Long id) {
        HeroCharacterResponseDTO hero = service.getHeroById(id);
        return ResponseEntity.ok(hero);

    }

    //create hero
    @PostMapping
    public ResponseEntity<HeroCharacterResponseDTO> createHero(@Valid @RequestBody HeroCharacterRequestDTO request) {
        HeroCharacterResponseDTO hero = service.createHero(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(hero);
    }

    //update hero
    @PatchMapping("/{id}")
    public ResponseEntity<HeroCharacterResponseDTO> updateHero(@PathVariable Long id, @Valid @RequestBody HeroCharacterRequestDTO request) {
        HeroCharacterResponseDTO hero = service.updateHero(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(hero);
    }

    //delete hero
    @DeleteMapping("/{id]")
    public ResponseEntity<Void> deleteHero(@PathVariable Long id) {
        service.deleteHero(id);
        return ResponseEntity.noContent().build();
    }

}
