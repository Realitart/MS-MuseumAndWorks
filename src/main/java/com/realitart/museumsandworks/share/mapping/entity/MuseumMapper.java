package com.realitart.museumsandworks.share.mapping.entity;

import com.realitart.museumsandworks.Domain.Museum;
import com.realitart.museumsandworks.Dtos.MuseumCreateDTO;
import com.realitart.museumsandworks.Dtos.MuseumGetDTO;
import com.realitart.museumsandworks.share.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class MuseumMapper {
    @Autowired
    EnhancedModelMapper mapper;


    public Page<Museum> modelListToPage(List<Museum> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, Museum.class), pageable, modelList.size());
    }
    public Page<MuseumGetDTO> dtoListToPage(List<MuseumGetDTO> dtoList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(dtoList, MuseumGetDTO.class), pageable, dtoList.size());
    }
    public Museum toModel(MuseumCreateDTO resource) {
        return mapper.map(resource, Museum.class);
    }

}
