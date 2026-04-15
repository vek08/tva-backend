package com.loki.TVA.controller;

import com.loki.TVA.dto.CharacterRequestDTO;
import com.loki.TVA.dto.CharacterResponseDTO;
import com.loki.TVA.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService service;

    //get all character
    @GetMapping
    public ResponseEntity<List<CharacterResponseDTO>> getAllCharacter() {

        List<CharacterResponseDTO> character = service.getAllCharacter();
        return ResponseEntity.ok(character);

    }

    //    get character by id
    @GetMapping("/{id}")
    public ResponseEntity<CharacterResponseDTO> getCharacterById(@PathVariable Long id) {
        CharacterResponseDTO character = service.getCharacterById(id);
        return ResponseEntity.ok(character);
    }

    //    create character

    @PostMapping
    public ResponseEntity<CharacterResponseDTO> createCharacter(@Valid @RequestBody CharacterRequestDTO request) {
        CharacterResponseDTO character = service.createCharacter(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(character);

    }

    //    update the character
    @PatchMapping("/{id}")
    public ResponseEntity<CharacterResponseDTO> updateCharacter(@PathVariable Long id, @Valid @RequestBody CharacterRequestDTO request) {
        CharacterResponseDTO character = service.updateCharacter(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(character);
    }


    //    delete the character

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        service.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }

}
