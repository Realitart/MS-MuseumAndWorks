package com.realitart.museumsandworks.Service;



import com.realitart.museumsandworks.Domain.Rating;
import com.realitart.museumsandworks.share.response.OperationResponse;

import java.util.List;

public interface IRatingService {
    OperationResponse createRating(Rating request);

    OperationResponse updateRating(Long assetId, Rating request);

    OperationResponse deleteRating(Long assetId);

    Rating getRating(Long assetId);

    List<Rating> getRatings();
    List<Rating> getRatingsByArtwork(Long artworkId);
}
