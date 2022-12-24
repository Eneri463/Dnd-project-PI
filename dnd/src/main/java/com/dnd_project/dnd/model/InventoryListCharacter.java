package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventory_list_char")
public class InventoryListCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "charID")
    private Long charId;

    @Column(name = "type")
    private Integer type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "objectID", referencedColumnName = "id")
    @JsonManagedReference
    private ObjectsList objectsList;

    public InventoryListCharacter(Long charId, ObjectsList objectsList) {
        this.charId = charId;
        this.objectsList = objectsList;
        this.type = 2;
    }

    public InventoryListCharacter()
    {
    }
}
