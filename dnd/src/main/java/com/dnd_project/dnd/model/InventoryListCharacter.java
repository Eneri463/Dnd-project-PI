package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventory_list_character")
public class InventoryListCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "charId")
    private Long charId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "objectId", referencedColumnName = "id")
    @JsonManagedReference
    private ObjectsList objectsList;
}
