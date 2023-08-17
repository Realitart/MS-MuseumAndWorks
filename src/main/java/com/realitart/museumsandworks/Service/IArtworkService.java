package com.realitart.museumsandworks.Service;



import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.share.response.OperationResponse;

import java.util.List;

public interface IArtworkService {
    OperationResponse createArtwork(Artwork request);

    OperationResponse updateArtwork(Long artworkId, Artwork request);

    OperationResponse deleteArtwork(Long artworkId);

    Artwork getArtwork(Long artwork);

    List<Artwork> getArtworks();
    List<Artwork> getArtworksByMuseum(Long museumId);
}
