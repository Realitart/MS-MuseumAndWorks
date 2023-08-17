package com.realitart.museumsandworks.Domain.Repositories;

import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArtworkIdAndEnableTrue(Artwork artwork);
    List<Comment> findByEnableTrue();
}
