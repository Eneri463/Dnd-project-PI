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
    private Long linksId;

    @Column(name = "userID")
    private Long userID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worldID", referencedColumnName = "id")
    @JsonManagedReference
    private Worlds worlds;

    public WorldsLinks(Long userID, Worlds worlds) {
        this.userID = userID;
        this.worlds = worlds;
    }
}
