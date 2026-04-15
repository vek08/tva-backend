package com.loki.TVA.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterResponseDTO {

    private String name;
    private String description;
    private String imageUrl;
}
