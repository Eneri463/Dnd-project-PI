package com.dnd_project.dnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "objects_list")
public class ObjectsList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String objectName;

    @Column(name = "description")
    private String description;
}
