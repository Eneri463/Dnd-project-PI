package com.dnd_project.dnd.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "characters")
public class CharacterTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long charID;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "age")
    private Integer age;

    @Column(name = "strength")
    private Integer strength;

    @Column(name = "dexterity")
    private Integer dexterity;

    @Column(name = "constitution")
    private Integer constitution;

    @Column(name = "intelligence")
    private Integer intelligence;

    @Column(name = "wisdom")
    private Integer wisdom;

    @Column(name = "charisma")
    private Integer charisma;

    @Column(name = "hp")
    private Integer hp;

    @Column(name = "addhp")
    private Integer addHp;

    @Column(name = "maxhp")
    private Integer maxHp;

    @Column(name = "classarmor")
    private Integer classArmor;

    @Column(name = "proficiencybonus")
    private Integer proficiencyBonus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classID", referencedColumnName = "id")
    @JsonManagedReference
    private ClassTable classtable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genderID", referencedColumnName = "id")
    @JsonManagedReference
    private Genders genders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raceID", referencedColumnName = "id")
    @JsonManagedReference
    private Race race;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "backgroundID", referencedColumnName = "id")
    @JsonManagedReference
    private Backgrounds background;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ideologyID", referencedColumnName = "id")
    @JsonManagedReference
    private Ideologies ideology;

    @OneToOne(mappedBy = "charTable")
    @JsonBackReference
    private CharacterListTable characterListTable;
}
