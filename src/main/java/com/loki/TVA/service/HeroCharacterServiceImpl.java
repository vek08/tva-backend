package com.loki.TVA.service;

import com.loki.TVA.dto.HeroCharacterRequestDTO;
import com.loki.TVA.dto.HeroCharacterResponseDTO;
import com.loki.TVA.exception.HeroCharacterNotFound;
import com.loki.TVA.model.HeroCharacterEntity;
import com.loki.TVA.repo.HeroCharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroCharacterServiceImpl implements HeroCharacterService {

    @Autowired
    private HeroCharacterRepo repo;

    //get all hero
    @Override
    public List<HeroCharacterResponseDTO> getAllHero() {
        List<HeroCharacterEntity> entity = repo.findAll();

        List<HeroCharacterResponseDTO> list = new ArrayList<>();
        for (HeroCharacterEntity db : entity) {
            list.add(HeroCharacterResponseDTO.builder()
                    .id(db.getId())
                    .title(db.getTitle())
                    .description(db.getDescription())
                    .imageUrl(db.getImageUrl())
                    .build()
            );

        }
        return list;
    }

    //get hero by id
    @Override
    public HeroCharacterResponseDTO getHeroById(Long id) {
        HeroCharacterEntity entity = repo.findById(id).orElseThrow(() -> new HeroCharacterNotFound(id));
        return HeroCharacterResponseDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .imageUrl(entity.getImageUrl())
                .build();
    }

    //create hero
    @Override
    public HeroCharacterResponseDTO createHero(HeroCharacterRequestDTO request) {
        HeroCharacterEntity entity = HeroCharacterEntity.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .imageUrl(request.getImageUrl())
                .build();

        HeroCharacterEntity saved = repo.save(entity);

        return HeroCharacterResponseDTO.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .imageUrl(saved.getImageUrl())
                .build();

    }

    //update hero
    @Override
    public HeroCharacterResponseDTO updateHero(Long id, HeroCharacterRequestDTO request) {
        HeroCharacterEntity entity = repo.findById(id).orElseThrow(() -> new HeroCharacterNotFound(id));
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setImageUrl(request.getImageUrl());

        HeroCharacterEntity updateSaved = repo.save(entity);

        return HeroCharacterResponseDTO.builder()
                .id(updateSaved.getId())
                .title(updateSaved.getTitle())
                .description(updateSaved.getDescription())
                .imageUrl(updateSaved.getImageUrl())
                .build();
    }

    //delete hero
    @Override
    public void deleteHero(Long id) {
        HeroCharacterEntity entity = repo.findById(id).orElseThrow(() -> new HeroCharacterNotFound(id));
        repo.delete(entity);
    }

}
