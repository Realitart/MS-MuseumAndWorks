package com.realitart.museumsandworks.Domain;

import com.realitart.museumsandworks.share.models.AuditModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Artwork")
public class Artwork extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MUSEUM_ID", nullable=false)
    Museum museumId;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable=false)
    Category categoryId;
    private Long assetId;
    private Long audioId;
    private String name;
    private String summary;
    private Double raiting;
    private String images;
}
