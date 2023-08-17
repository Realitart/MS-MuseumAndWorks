package com.realitart.museumsandworks.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtworkUpdateDTO {
    private Long assetId;
    private Long audioId;
    private String name;
    private String summary;
    private Double raiting;
    private String images;
}
