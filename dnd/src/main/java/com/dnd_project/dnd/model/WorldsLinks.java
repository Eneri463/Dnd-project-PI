package com.dnd_project.dnd.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "worlds_links")
public class WorldsLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "userID")
    private Long userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worldID", referencedColumnName = "id")
    @JsonManagedReference
    private Worlds worlds;

    public WorldsLinks(Long userId, Worlds worlds) {
        this.userId = userId;
        this.worlds = worlds;
    }
}
