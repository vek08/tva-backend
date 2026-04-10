package com.loki.TVA.repo;

import com.loki.TVA.model.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepo extends JpaRepository<Variant,Long> {
}
