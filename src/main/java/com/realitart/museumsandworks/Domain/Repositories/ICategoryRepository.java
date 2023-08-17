package com.realitart.museumsandworks.Domain.Repositories;

import com.realitart.museumsandworks.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByEnableTrueAndId(Long id);
    List<Category> findByEnableTrue();
}
