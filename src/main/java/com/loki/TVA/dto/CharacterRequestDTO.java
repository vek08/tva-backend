package com.loki.TVA.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterRequestDTO {

    @NotNull(message = "name required")
    private String name;
    @NotNull(message = "description required")
    private String description;
    @NotNull(message = "image required")
    private String imageUrl;
}
