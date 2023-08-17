package com.realitart.museumsandworks.Controller;

import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.Dtos.ArtworkCreateDTO;
import com.realitart.museumsandworks.Dtos.ArtworkUpdateDTO;
import com.realitart.museumsandworks.Service.IArtworkService;
import com.realitart.museumsandworks.share.mapping.entity.ArtworkMapper;
import com.realitart.museumsandworks.share.response.OperationResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artwork")
public class ArtworkController {
    @Autowired
    IArtworkService artworkService;
    @Autowired
    private ArtworkMapper mapper;
    
    @PostMapping
    @Operation(summary = "Create a new artwork")
    OperationResponse createArtwork(@Valid @RequestBody ArtworkCreateDTO request){
        return artworkService.createArtwork(mapper.toModel(request));
    }
    
    @PutMapping("/{artworkId}")
    @Operation(summary = "Update a artwork")
    OperationResponse updateArtwork(@PathVariable Long artworkId,@RequestBody ArtworkUpdateDTO request){
        return artworkService.updateArtwork(artworkId,mapper.toModel(request));
    }
    
    @DeleteMapping("/{artworkId}")
    @Operation(summary = "Delete a artwork")
    OperationResponse deleteArtwork(@PathVariable Long artworkId){
        return artworkService.deleteArtwork(artworkId);
    }
    
    @GetMapping("/{artworkId}")
    @Operation(summary = "Get a artwork by id")
    ResponseEntity<Artwork> getArtworkData(@PathVariable Long artworkId){
        return ResponseEntity.ok(artworkService.getArtwork(artworkId));
    }
    
    @GetMapping
    @Operation(summary = "Get all artworks")
    ResponseEntity<Page<Artwork>> getAllArtworks(@RequestParam(required = false) Long museumId,Pageable pageable){
        if(museumId == null){
            return ResponseEntity.ok(mapper.modelListToPage(artworkService.getArtworks(),pageable));
        }
        return ResponseEntity.ok(mapper.modelListToPage(artworkService.getArtworksByMuseum(museumId),pageable));
    }
    
    
}
