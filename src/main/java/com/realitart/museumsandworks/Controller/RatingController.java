package com.realitart.museumsandworks.Controller;

import com.realitart.museumsandworks.Domain.Rating;
import com.realitart.museumsandworks.Dtos.RatingCreateDTO;
import com.realitart.museumsandworks.Service.IRatingService;
import com.realitart.museumsandworks.share.mapping.entity.RatingMapper;
import com.realitart.museumsandworks.share.response.OperationResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    IRatingService ratingService;
    @Autowired
    private RatingMapper mapper;
    
    @PostMapping
    @Operation(summary = "Create a new rating")
    OperationResponse createRating(@Valid @RequestBody RatingCreateDTO request){
        return ratingService.createRating(mapper.toModel(request));
    }
    
    @PutMapping("/{ratingId}")
    @Operation(summary = "Update a rating")
    OperationResponse updateRating(@PathVariable Long ratingId,@RequestBody RatingCreateDTO request){
        return ratingService.updateRating(ratingId,mapper.toModel(request));
    }
    
    @DeleteMapping("/{ratingId}")
    @Operation(summary = "Delete a rating")
    OperationResponse deleteRating(@PathVariable Long ratingId){
        return ratingService.deleteRating(ratingId);
    }
    
    @GetMapping("/{ratingId}")
    @Operation(summary = "Get a rating by id")
    ResponseEntity<Rating> getRatingData(@PathVariable Long ratingId){
        return ResponseEntity.ok(ratingService.getRating(ratingId));
    }
    
    @GetMapping
    @Operation(summary = "Get all ratings")
    ResponseEntity<Page<Rating>> getAllRatings(@RequestHeader(required = false) Long artworkId ,Pageable pageable){
        if(artworkId == null) {
            return ResponseEntity.ok(mapper.modelListToPage(ratingService.getRatings(), pageable));
        } else {
            return ResponseEntity.ok(mapper.modelListToPage(ratingService.getRatingsByArtwork(artworkId), pageable));
        }
    }
    
    
}
