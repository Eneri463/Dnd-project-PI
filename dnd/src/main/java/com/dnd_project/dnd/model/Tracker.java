package com.dnd_project.dnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tracker")
public class Tracker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "worldID")
    private Long worldId;

    @Column(name = "name")
    private String charName;

    @Column(name = "initiative")
    private Double initiative;

    @Column(name = "color")
    private String color;

    public Tracker(Long worldID, String name, Double initiative, String color) {
        this.worldId = worldID;
        this.charName = name;
        this.initiative = initiative;
        this.color = color;
    }

    public Tracker()
    {

    }
}
