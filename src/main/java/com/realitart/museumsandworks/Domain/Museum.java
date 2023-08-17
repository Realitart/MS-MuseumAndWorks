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
@Table(name = "Museum")
public class Museum extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long id;
    private Long departmentId;
    private String name;
    private String description;
    private String address;
    private String images;
}
