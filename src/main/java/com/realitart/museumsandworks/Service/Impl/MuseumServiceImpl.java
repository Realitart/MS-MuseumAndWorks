package com.realitart.museumsandworks.Service.Impl;

import com.realitart.museumsandworks.Domain.Museum;
import com.realitart.museumsandworks.Domain.Repositories.IDepartmentRepository;
import com.realitart.museumsandworks.Domain.Repositories.IMuseumRepository;
import com.realitart.museumsandworks.Dtos.MuseumGetDTO;
import com.realitart.museumsandworks.Service.IMuseumService;
import com.realitart.museumsandworks.share.exceptions.ResourceNotFoundException;
import com.realitart.museumsandworks.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseumServiceImpl implements IMuseumService {
    private static final String ENTITY = "Museum";
    @Autowired
    IMuseumRepository _museumRepo;

    @Autowired
    IDepartmentRepository _departmentRepo;

    @Override
    public OperationResponse createMuseum(Museum request) {
        try{            request.setId(null);

            _museumRepo.save(request);
            return new OperationResponse(true, "Museum creado correctamente");
        } catch (Exception e) {
            return new OperationResponse(false, "Error al crear el Museum");
        }
    }

    @Override
    public OperationResponse updateMuseum(Long museumId, Museum request) {
        return _museumRepo.findById(museumId).map(
                museum -> {
                    if(request.getName() != null) museum.setName(request.getName());
                    if(request.getDescription() != null) museum.setDescription(request.getDescription());
                    if(request.getAddress() != null) museum.setAddress(request.getAddress());
                    if(request.getImages() != null) museum.setImages(request.getImages());
                    _museumRepo.save(museum);
                    return new OperationResponse(true, "Museum actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, museumId));
    }

    @Override
    public OperationResponse deleteMuseum(Long museumId) {
        return _museumRepo.findById(museumId).map(
                artwork -> {
                    _museumRepo.delete(artwork);
                    return new OperationResponse(true, "Museum eliminado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, museumId));
    }

    @Override
    public Museum getMuseum(Long museumId) {
        try {
            return _museumRepo.findByEnableTrueAndId(museumId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, museumId));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el Museum", e);
        }
    }

    @Override
    public List<MuseumGetDTO> getMuseums() {
        try {
            List<Museum> getMuseums = _museumRepo.findByEnableTrue();
            return getMuseums.stream().map(museum -> new MuseumGetDTO(
                    _departmentRepo.findById(museum.getDepartmentId()).orElseThrow(() -> new ResourceNotFoundException("Department", museum.getDepartmentId())).getName(),
                    museum.getName(),
                    museum.getDescription(),
                    museum.getAddress(),
                    museum.getImages()
            )).toList();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Museums", e);
        }
    }
    
}
