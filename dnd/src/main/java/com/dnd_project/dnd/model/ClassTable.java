package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "class_table")
public class ClassTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String className;

    @Column(name = "description")
    private String description;

    @OneToOne(mappedBy = "classtable")
    @JsonBackReference
    private CharacterTable charactertable;
}
