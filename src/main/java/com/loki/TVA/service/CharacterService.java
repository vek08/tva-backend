package com.loki.TVA.service;

import com.loki.TVA.dto.CharacterRequestDTO;
import com.loki.TVA.dto.CharacterResponseDTO;

import java.util.List;

public interface CharacterService {
    List<CharacterResponseDTO> getAllCharacter();
    CharacterResponseDTO getCharacterById(Long id);
    CharacterResponseDTO createCharacter(CharacterRequestDTO request);
    CharacterResponseDTO updateCharacter(Long id, CharacterRequestDTO request);
    void deleteCharacter(Long id);
}
