package com.loki.TVA.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VariantRequestDTO {

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "timelineID require")
    private String timelineId;
    @NotBlank(message = "status is required")
    private String status;
    @NotBlank(message = "threatLevel is require")
    private String threatLevel;

}
