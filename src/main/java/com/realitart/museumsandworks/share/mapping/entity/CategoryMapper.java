package com.realitart.museumsandworks.share.mapping.entity;

import com.realitart.museumsandworks.Domain.Category;
import com.realitart.museumsandworks.Dtos.CategoryCreateDTO;
import com.realitart.museumsandworks.share.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CategoryMapper {
    @Autowired
    EnhancedModelMapper mapper;


    public Page<Category> modelListToPage(List<Category> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, Category.class), pageable, modelList.size());
    }
    public Category toModel(CategoryCreateDTO resource) {
        return mapper.map(resource, Category.class);
    }

}
