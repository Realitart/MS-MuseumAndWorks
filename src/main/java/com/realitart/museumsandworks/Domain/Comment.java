package com.realitart.museumsandworks.Domain;

import com.realitart.museumsandworks.share.models.AuditModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Comment")
public class Comment extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ARTWORK_ID", nullable=false)
    Artwork artworkId;
    private Long userId;
    private String description;
}
