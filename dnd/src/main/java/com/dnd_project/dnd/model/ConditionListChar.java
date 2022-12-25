package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "condition_list_char")
public class ConditionListChar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "charID")
    private Long charId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conditionID", referencedColumnName = "id")
    @JsonManagedReference
    private ConditionList conditionList;

    public ConditionListChar(Long charId, ConditionList conditionList) {
        this.charId = charId;
        this.conditionList = conditionList;
    }

    public ConditionListChar() {
    }
}
