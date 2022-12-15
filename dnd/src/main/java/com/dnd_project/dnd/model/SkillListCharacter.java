package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "skill_list_character")
public class SkillListCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "charId")
    private Long charId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skillId", referencedColumnName = "id")
    @JsonManagedReference
    private SkillList skillList;
}
