package com.dnd_project.dnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ideologies")
public class Ideologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String ideologiesName;
}
