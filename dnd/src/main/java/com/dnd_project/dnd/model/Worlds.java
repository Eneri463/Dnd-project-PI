package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "worlds")
public class Worlds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String worldName;

    @Column(name = "description")
    private String description;

    public Worlds(String name, String description) {
        this.worldName = name;
        this.description = description;
    }

    public Worlds(Long id, String name, String description) {
        this.id = id;
        this.worldName = name;
        this.description = description;
    }

    public Worlds() {
    }
}
