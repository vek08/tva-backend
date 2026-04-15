package com.loki.TVA.repo;

import com.loki.TVA.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepo extends JpaRepository<CharacterEntity,Long> {
}
