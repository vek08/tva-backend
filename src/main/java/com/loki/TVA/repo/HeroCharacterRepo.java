package com.loki.TVA.repo;

import com.loki.TVA.model.HeroCharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroCharacterRepo extends JpaRepository<HeroCharacterEntity,Long> {
}
