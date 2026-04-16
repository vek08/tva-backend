package com.loki.TVA.repo;

import com.loki.TVA.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepo extends JpaRepository<CharacterEntity,Long> {
}
