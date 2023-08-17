package com.realitart.museumsandworks.Domain.Repositories;

import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.Domain.Category;
import com.realitart.museumsandworks.Domain.Museum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IArtworkRepository extends JpaRepository<Artwork, Long> {
    List<Artwork> findByMuseumIdAndEnableTrue(Museum museum);
    Optional<Artwork> findByEnableTrueAndId(Long id);
    List<Artwork> findByEnableTrue();
}
