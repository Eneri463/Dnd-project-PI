package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "spell_list")
public class SpellList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String spellName;

    @Column(name = "description")
    private String description;

    @Column(name = "level")
    private Integer level;
}
