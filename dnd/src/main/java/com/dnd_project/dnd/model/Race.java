package com.dnd_project.dnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String raceName;

    @Column(name = "description")
    private Integer description;
}
