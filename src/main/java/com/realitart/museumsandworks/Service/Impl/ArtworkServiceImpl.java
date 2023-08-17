package com.realitart.museumsandworks.Service.Impl;

import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.Domain.Museum;
import com.realitart.museumsandworks.Domain.Repositories.IArtworkRepository;
import com.realitart.museumsandworks.Domain.Repositories.IMuseumRepository;
import com.realitart.museumsandworks.Service.IArtworkService;
import com.realitart.museumsandworks.share.exceptions.ResourceNotFoundException;
import com.realitart.museumsandworks.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
@Service
public class ArtworkServiceImpl implements IArtworkService {
    private static final String ENTITY = "Artwork";
    @Autowired
    IArtworkRepository _artworkRepo;
    @Autowired
    IMuseumRepository _museumRepo;

    @Override
    public OperationResponse createArtwork(Artwork request) {
        try{
            _artworkRepo.save(request);
            return new OperationResponse(true, "Artwork creado correctamente");
        } catch (Exception e) {
            return new OperationResponse(false, "Error al crear el Artwork");
        }
    }

    @Override
    public OperationResponse updateArtwork(Long artworkId, Artwork request) {
        return _artworkRepo.findById(artworkId).map(
                artwork -> {
                    if (request.getName() != null) artwork.setName(request.getName());
                    if (request.getSummary() != null) artwork.setSummary(request.getSummary());
                    if (request.getRaiting() != null) artwork.setRaiting(request.getRaiting());
                    if (request.getImages() != null) artwork.setImages(request.getImages());
                    if (request.getAssetId() != null) artwork.setAssetId(request.getAssetId());
                    if (request.getAudioId() != null) artwork.setAudioId(request.getAudioId());
                    _artworkRepo.save(artwork);
                    return new OperationResponse(true, "Artwork actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artworkId));
    }

    @Override
    public OperationResponse deleteArtwork(Long artworkId) {
        return _artworkRepo.findById(artworkId).map(
                artwork -> {
                    _artworkRepo.delete(artwork);
                    return new OperationResponse(true, "Artwork eliminado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artworkId));
    }

    @Override
    public Artwork getArtwork(Long artworkId) {
        try {
            return _artworkRepo.findByEnableTrueAndId(artworkId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artworkId));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el Artwork", e);
        }
    }

    @Override
    public List<Artwork> getArtworks() {
        try {
            return _artworkRepo.findByEnableTrue();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Artworks", e);
        }
    }

    @Override
    public List<Artwork> getArtworksByMuseum(Long museumId) {
        try {
            Museum museum = _museumRepo.findById(museumId).orElseThrow(() -> new ResourceNotFoundException("Museum", museumId));
            return _artworkRepo.findByMuseumIdAndEnableTrue(museum);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Artworks", e);
        }
    }
}
