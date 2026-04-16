package com.loki.TVA.service;

import com.loki.TVA.dto.CharacterRequestDTO;
import com.loki.TVA.dto.CharacterResponseDTO;
import com.loki.TVA.exception.CharacterNotFoundException;
import com.loki.TVA.model.CharacterEntity;
import com.loki.TVA.repo.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepo repo;

    //get all character
    @Override
    public List<CharacterResponseDTO> getAllCharacter() {

        List<CharacterEntity> entity = repo.findAll();

        List<CharacterResponseDTO> list = new ArrayList<>();
        for (CharacterEntity db : entity) {
            list.add(CharacterResponseDTO.builder()
                    .id(db.getId())
                    .name(db.getName())
                    .description(db.getDescription())
                    .imageUrl(db.getImageUrl())
                    .build()
            );
        }
        return list;
    }

//        get character by id

    @Override
    public CharacterResponseDTO getCharacterById(Long id) {
        CharacterEntity entity = repo.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
        return CharacterResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .imageUrl(entity.getImageUrl())
                .build();
    }

    //create the character
    @Override
    public CharacterResponseDTO createCharacter(CharacterRequestDTO request) {
        CharacterEntity entity = CharacterEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .imageUrl(request.getImageUrl())
                .build();

        CharacterEntity saved = repo.save(entity);

        return CharacterResponseDTO.builder()
                .id(saved.getId())
                .name(saved.getName())
                .description(saved.getDescription())
                .imageUrl(saved.getImageUrl())
                .build();
    }

    //update the character
    @Override
    public CharacterResponseDTO updateCharacter(Long id, CharacterRequestDTO request) {
        CharacterEntity entity = repo.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setImageUrl(request.getImageUrl());

        CharacterEntity updateSaved = repo.save(entity);
        return CharacterResponseDTO.builder()
                .id(updateSaved.getId())
                .name(updateSaved.getName())
                .description(updateSaved.getDescription())
                .imageUrl(updateSaved.getImageUrl())
                .build();
    }

    //delete the character
    @Override
    public void deleteCharacter(Long id) {
        CharacterEntity entity = repo.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
        repo.delete(entity);
    }

}
