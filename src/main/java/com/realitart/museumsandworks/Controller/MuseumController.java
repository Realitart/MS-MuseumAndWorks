package com.realitart.museumsandworks.Controller;

import com.realitart.museumsandworks.Domain.Museum;
import com.realitart.museumsandworks.Dtos.MuseumCreateDTO;
import com.realitart.museumsandworks.Service.IMuseumService;
import com.realitart.museumsandworks.share.mapping.entity.MuseumMapper;
import com.realitart.museumsandworks.share.response.OperationResponse;
//import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/museum")
public class MuseumController {
    @Autowired
    IMuseumService museumService;
    @Autowired
    private MuseumMapper mapper;
    
    @PostMapping
    //@Operation(summary = "Create a new museum")
    OperationResponse createMuseum(@Valid @RequestBody MuseumCreateDTO request){
        return museumService.createMuseum(mapper.toModel(request));
    }
    
    @PutMapping("/{museumId}")
    //@Operation(summary = "Update a museum")
    OperationResponse updateMuseum(@PathVariable Long museumId,@RequestBody MuseumCreateDTO request){
        return museumService.updateMuseum(museumId,mapper.toModel(request));
    }
    
    @DeleteMapping("/{museumId}")
    //@Operation(summary = "Delete a museum")
    OperationResponse deleteMuseum(@PathVariable Long museumId){
        return museumService.deleteMuseum(museumId);
    }
    
    @GetMapping("/{museumId}")
    //@Operation(summary = "Get a museum by id")
    ResponseEntity<Museum> getMuseumData(@PathVariable Long museumId){
        return ResponseEntity.ok(museumService.getMuseum(museumId));
    }
    
    @GetMapping
    //@Operation(summary = "Get all museums")
    ResponseEntity<Page<Museum>> getAllMuseums(Pageable pageable){
            return ResponseEntity.ok(mapper.modelListToPage(museumService.getMuseums(),pageable));

    }
}
