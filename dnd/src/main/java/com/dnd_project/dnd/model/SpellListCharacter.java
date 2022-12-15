package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "spell_list_character")
public class SpellListCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "charId")
    private Long charId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spellId", referencedColumnName = "id")
    @JsonManagedReference
    private SpellList spellList;

}
