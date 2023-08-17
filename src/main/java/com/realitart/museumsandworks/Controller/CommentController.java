package com.realitart.museumsandworks.Controller;

import com.realitart.museumsandworks.Domain.Comment;
import com.realitart.museumsandworks.Dtos.CommentCreateDTO;
import com.realitart.museumsandworks.Service.ICommentService;
import com.realitart.museumsandworks.share.mapping.entity.CommentMapper;
import com.realitart.museumsandworks.share.response.OperationResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    ICommentService commentService;
    @Autowired
    private CommentMapper mapper;
    
    @PostMapping
    @Operation(summary = "Create a new comment")
    OperationResponse createComment(@Valid @RequestBody CommentCreateDTO request){
        return commentService.createComment(mapper.toModel(request));
    }
    
    @PutMapping("/{commentId}")
    @Operation(summary = "Update a comment")
    OperationResponse updateComment(@PathVariable Long commentId,@RequestBody CommentCreateDTO request){
        return commentService.updateComment(commentId,mapper.toModel(request));
    }
    
    @DeleteMapping("/{commentId}")
    @Operation(summary = "Delete a comment")
    OperationResponse deleteComment(@PathVariable Long commentId){
        return commentService.deleteComment(commentId);
    }
    
    @GetMapping("/{commentId}")
    @Operation(summary = "Get a comment by id")
    ResponseEntity<Comment> getCommentData(@PathVariable Long commentId){
        return ResponseEntity.ok(commentService.getComment(commentId));
    }
    
    @GetMapping
    @Operation(summary = "Get all comments")
    ResponseEntity<Page<Comment>> getAllComments(@RequestHeader(required = false) Long artworkId ,Pageable pageable){
        if(artworkId == null) {
            return ResponseEntity.ok(mapper.modelListToPage(commentService.getComments(), pageable));
        } else {
            return ResponseEntity.ok(mapper.modelListToPage(commentService.getCommentsByArtwork(artworkId), pageable));
        }

    }
    
    
}
