package com.realitart.museumsandworks.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingCreateDTO {
    @Positive(message = "El campo 'artworkId' debe ser un número positivo.")
    private Long artworkId;
    @NotNull(message = "El campo 'score' no puede ser nulo.")
    private Double score;
}
