package com.realitart.museumsandworks.Service.Impl;

import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.Domain.Rating;
import com.realitart.museumsandworks.Domain.Repositories.IArtworkRepository;
import com.realitart.museumsandworks.Domain.Repositories.IRatingRepository;
import com.realitart.museumsandworks.Service.IRatingService;
import com.realitart.museumsandworks.share.exceptions.ResourceNotFoundException;
import com.realitart.museumsandworks.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements IRatingService {
    private static final String ENTITY = "Rating";
    @Autowired
    IRatingRepository _ratingRepo;
    @Autowired
    IArtworkRepository _artworkRepo;

    @Override
    public OperationResponse createRating(Rating request) {
        try{
            _ratingRepo.save(request);
            return new OperationResponse(true, "Rating creado correctamente");
        } catch (Exception e) {
            return new OperationResponse(false, "Error al crear el Rating");
        }
    }

    @Override
    public OperationResponse updateRating(Long commentId, Rating request) {
        return _ratingRepo.findById(commentId).map(
                artwork -> {
                    if(request.getScore() != null) artwork.setScore(request.getScore());
                    _ratingRepo.save(artwork);

                    return new OperationResponse(true, "Rating actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public OperationResponse deleteRating(Long commentId) {
        return _ratingRepo.findById(commentId).map(
                artwork -> {
                    _ratingRepo.delete(artwork);
                    return new OperationResponse(true, "Rating eliminado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public Rating getRating(Long commentId) {
        try {
            return _ratingRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el Rating", e);
        }
    }

    @Override
    public List<Rating> getRatings() {
        try {
            return _ratingRepo.findAll();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Ratings", e);
        }
    }

    @Override
    public List<Rating> getRatingsByArtwork(Long artworkId) {
        try {
            Artwork artwork = _artworkRepo.findById(artworkId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artworkId));
            return _ratingRepo.findByArtworkId(artwork);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Ratings", e);
        }
    }
}
