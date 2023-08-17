package com.realitart.museumsandworks.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateDTO {
    @NotBlank(message = "El campo 'name' no puede estar vacío o ser nulo.")
    private String name;
    @NotBlank(message = "El campo 'description' no puede estar vacío o ser nulo.")
    private String description;
}
