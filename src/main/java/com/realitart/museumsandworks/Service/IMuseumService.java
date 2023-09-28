package com.realitart.museumsandworks.Service;



import com.realitart.museumsandworks.Domain.Museum;
import com.realitart.museumsandworks.Dtos.MuseumGetDTO;
import com.realitart.museumsandworks.share.response.OperationResponse;

import java.util.List;

public interface IMuseumService {
    OperationResponse createMuseum(Museum request);

    OperationResponse updateMuseum(Long museumId, Museum request);

    OperationResponse deleteMuseum(Long museumId);

    Museum getMuseum(Long museum);

    List<MuseumGetDTO> getMuseums();
}
