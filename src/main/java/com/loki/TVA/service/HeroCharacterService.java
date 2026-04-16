package com.loki.TVA.service;

import com.loki.TVA.dto.HeroCharacterRequestDTO;
import com.loki.TVA.dto.HeroCharacterResponseDTO;

import java.util.List;

public interface HeroCharacterService {
    List<HeroCharacterResponseDTO> getAllHero();

    HeroCharacterResponseDTO getHeroById(Long id);

    HeroCharacterResponseDTO createHero(HeroCharacterRequestDTO request);

    HeroCharacterResponseDTO updateHero(Long id, HeroCharacterRequestDTO request);

    void deleteHero(Long id);
}
