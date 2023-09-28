package com.realitart.museumsandworks.Dtos;

import jakarta.validation.constraints.NotBlank;
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
public class CommentCreateDTO {
    @NotNull(message = "El campo 'userId' no puede ser nulo.")
    private Long userId;
    @Positive(message = "El campo 'artworkId' debe ser un número positivo.")
    private Long artworkId;
    @NotBlank(message = "El campo 'description' no puede estar vacío o ser nulo.")
    private String description;
}
