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
public class MuseumGetDTO {
    private Long id;
    private String department;
    private String name;
    private String description;
    private String address;
    private String images;
}
