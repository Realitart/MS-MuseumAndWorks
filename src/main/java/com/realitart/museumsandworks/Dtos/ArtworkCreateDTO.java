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
public class ArtworkCreateDTO {
    @NotNull(message = "El campo 'museumId' no puede estar vacío o ser nulo.")
    private Long museumId;
    @NotNull(message = "El campo 'categoryId' no puede estar vacío o ser nulo.")
    private Long categoryId;
    @NotNull(message = "El campo 'assetId' no puede estar vacío o ser nulo.")
    private Long assetId;
    @NotNull(message = "El campo 'audioId' no puede estar vacío o ser nulo.")
    private Long audioId;
    @NotBlank(message = "El campo 'name' no puede estar vacío o ser nulo.")
    private String name;
    @NotBlank(message = "El campo 'summary' no puede estar vacío o ser nulo.")
    private String summary;
    private Double raiting;
    private String images;


}
