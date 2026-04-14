package com.loki.TVA.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VariantResponseDTO {
    private Long id;
    private String name;
    private String timelineId;
    private String threatLevel;
    private String status;
}
