package com.realitart.museumsandworks.share.mapping.entity;

import com.realitart.museumsandworks.Domain.Comment;
import com.realitart.museumsandworks.Dtos.CommentCreateDTO;
import com.realitart.museumsandworks.share.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CommentMapper {
    @Autowired
    EnhancedModelMapper mapper;


    public Page<Comment> modelListToPage(List<Comment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, Comment.class), pageable, modelList.size());
    }
    public Comment toModel(CommentCreateDTO resource) {
        return mapper.map(resource, Comment.class);
    }

}
