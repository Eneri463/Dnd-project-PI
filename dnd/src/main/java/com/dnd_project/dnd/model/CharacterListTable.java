package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "characters_list")
public class CharacterListTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userID")
    private Long userID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "charID", referencedColumnName = "charID")
    @JsonManagedReference
    private CharacterTable charTable;

    public CharacterListTable(Long userID, CharacterTable charTable) {
        this.userID = userID;
        this.charTable = charTable;
    }

    public CharacterListTable() {
    }

}
