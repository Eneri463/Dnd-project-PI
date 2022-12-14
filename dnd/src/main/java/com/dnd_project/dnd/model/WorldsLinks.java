package com.dnd_project.dnd.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "worlds_links")
public class WorldsLinks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userID")
    private Long userID;

    @Column(name = "characterID")
    private Long worldID;
}
