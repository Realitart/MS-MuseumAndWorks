package com.realitart.museumsandworks.Domain.Repositories;

import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.Domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByArtworkId(Artwork artworkId);
}
