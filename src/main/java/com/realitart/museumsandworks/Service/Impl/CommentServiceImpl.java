package com.realitart.museumsandworks.Service.Impl;

import com.realitart.museumsandworks.Domain.Artwork;
import com.realitart.museumsandworks.Domain.Comment;
import com.realitart.museumsandworks.Domain.Repositories.IArtworkRepository;
import com.realitart.museumsandworks.Domain.Repositories.ICommentRepository;
import com.realitart.museumsandworks.Service.ICommentService;
import com.realitart.museumsandworks.share.exceptions.ResourceNotFoundException;
import com.realitart.museumsandworks.share.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    private static final String ENTITY = "Comment";
    @Autowired
    ICommentRepository _commentRepo;
    @Autowired
    IArtworkRepository _artworkRepo;

    @Override
    public OperationResponse createComment(Comment request) {
        try{
            _commentRepo.save(request);
            return new OperationResponse(true, "Comment creado correctamente");
        } catch (Exception e) {
            return new OperationResponse(false, "Error al crear el Comment");
        }
    }

    @Override
    public OperationResponse updateComment(Long commentId, Comment request) {
        return _commentRepo.findById(commentId).map(
                comment -> {
                    if(request.getDescription() != null) comment.setDescription(request.getDescription());
                    _commentRepo.save(comment);

                    return new OperationResponse(true, "Comment actualizado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public OperationResponse deleteComment(Long commentId) {
        return _commentRepo.findById(commentId).map(
                comment -> {
                    _commentRepo.delete(comment);
                    return new OperationResponse(true, "Comment eliminado correctamente");
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public Comment getComment(Long commentId) {
        try {
            return _commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener el Comment", e);
        }
    }

    @Override
    public List<Comment> getComments() {
        try {
            return _commentRepo.findByEnableTrue();
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Comments", e);
        }
    }

    @Override
    public List<Comment> getCommentsByArtwork(Long artworkId) {
        try {
            Artwork artwork = _artworkRepo.findById(artworkId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artworkId));
            return _commentRepo.findByArtworkIdAndEnableTrue(artwork);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al obtener los Comments", e);
        }
    }
}
