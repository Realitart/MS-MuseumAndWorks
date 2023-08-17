package com.realitart.museumsandworks.Domain.Repositories;

import com.realitart.museumsandworks.Domain.Category;
import com.realitart.museumsandworks.Domain.Museum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IMuseumRepository extends JpaRepository<Museum, Long> {

    Optional<Museum> findByEnableTrueAndId(Long id);
    List<Museum> findByEnableTrue();
}
