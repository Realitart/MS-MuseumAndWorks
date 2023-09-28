package com.realitart.museumsandworks.Service;



import com.realitart.museumsandworks.Domain.Comment;
import com.realitart.museumsandworks.Dtos.CommentCreateDTO;
import com.realitart.museumsandworks.share.response.OperationResponse;

import java.util.List;

public interface ICommentService {
    OperationResponse createComment(CommentCreateDTO request);

    OperationResponse updateComment(Long commentId, Comment request);

    OperationResponse deleteComment(Long commentId);

    Comment getComment(Long commentId);

    List<Comment> getComments();
    List<Comment> getCommentsByArtwork(Long artworkId);
}
