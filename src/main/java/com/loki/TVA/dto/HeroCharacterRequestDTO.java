package com.loki.TVA.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HeroCharacterRequestDTO {
    @NotNull(message = "title required")
    private String title;
    @NotNull(message = "description required")
    private String description;
    @NotNull(message = "image required")
    private String imageUrl;
}
