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
public class MuseumCreateDTO {
    private Long DepartmentId;
    @NotBlank(message = "El campo 'name' no puede estar vacío o ser nulo.")
    private String name;
    @NotBlank(message = "El campo 'description' no puede estar vacío o ser nulo.")
    private String description;
    private String address;
    private String images;
}
