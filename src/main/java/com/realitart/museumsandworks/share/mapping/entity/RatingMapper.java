package com.realitart.museumsandworks.share.mapping.entity;

import com.realitart.museumsandworks.Domain.Rating;
import com.realitart.museumsandworks.Dtos.RatingCreateDTO;
import com.realitart.museumsandworks.share.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RatingMapper {
    @Autowired
    EnhancedModelMapper mapper;


    public Page<Rating> modelListToPage(List<Rating> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, Rating.class), pageable, modelList.size());
    }
    public Rating toModel(RatingCreateDTO resource) {
        return mapper.map(resource, Rating.class);
    }

}
