package com.realitart.museumsandworks.share.mapping.configuration;


import com.realitart.museumsandworks.share.mapping.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public ArtworkMapper ArtworkMapper() {
        return new ArtworkMapper(modelMapper());
    }
    @Bean
    public MuseumMapper MuseumMapper() {
        return new MuseumMapper();
    }
    @Bean
    public CommentMapper CommentMapper() {
        return new CommentMapper();
    }
    @Bean
    public RatingMapper RatingMapper() {
        return new RatingMapper();
    }
    @Bean
    public CategoryMapper CategoryMapper() {
        return new CategoryMapper();
    }
}
