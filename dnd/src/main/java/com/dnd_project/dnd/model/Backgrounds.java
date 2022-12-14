package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "backgrounds")
public class Backgrounds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String background;

    @Column(name = "description")
    private Integer description;

    @OneToOne(mappedBy = "background")
    @JsonBackReference
    private CharacterTable charactertable;
}
