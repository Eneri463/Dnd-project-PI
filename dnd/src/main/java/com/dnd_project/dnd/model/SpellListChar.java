package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "spell_list_char")
public class SpellListChar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "charID")
    private Long charId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spellID", referencedColumnName = "id")
    @JsonManagedReference
    private SpellList spellList;

}
