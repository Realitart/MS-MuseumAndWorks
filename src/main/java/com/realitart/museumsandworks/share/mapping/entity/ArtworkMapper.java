package com.realitart.museumsandworks.share.mapping.entity;

import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.Dtos.ArtworkCreateDTO;
import com.realitart.museumsandworks.Dtos.ArtworkUpdateDTO;
import com.realitart.museumsandworks.share.mapping.configuration.EnhancedModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ArtworkMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public ArtworkMapper(EnhancedModelMapper mapper) {
        this.mapper = mapper;
        mapper.addMappings(new PropertyMap<ArtworkCreateDTO, Artwork>() {
            protected void configure() {
                // Omitir la asignación de un valor a la propiedad 'id' de 'Artwork'
                skip(destination.getId());
            }
        });
        mapper.addMappings(new PropertyMap<ArtworkUpdateDTO, Artwork>() {
            protected void configure() {
                // Omitir la asignación de un valor a la propiedad 'id' de 'Artwork'
                skip(destination.getId());
            }
        });
    }

    public Page<Artwork> modelListToPage(List<Artwork> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, Artwork.class), pageable, modelList.size());
    }

    public Artwork toModel(ArtworkCreateDTO resource) {
        return mapper.map(resource, Artwork.class);
    }

    public Artwork toModel(ArtworkUpdateDTO resource) {
        return mapper.map(resource, Artwork.class);
    }
}
