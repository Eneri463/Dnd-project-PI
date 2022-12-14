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
    private Integer worldID;

    @Column(name = "name")
    private String name;

    @Column(name = "initiative")
    private Integer initiative;

    @Column(name = "color")
    private String color;
}
