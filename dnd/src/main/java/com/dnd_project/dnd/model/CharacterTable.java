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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classID", referencedColumnName = "id")
    @JsonManagedReference
    private ClassTable classtable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genderID", referencedColumnName = "id")
    @JsonManagedReference
    private Genders genders;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "raceID", referencedColumnName = "id")
    @JsonManagedReference
    private Race race;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "backgroundID", referencedColumnName = "id")
    @JsonManagedReference
    private Backgrounds background;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ideologyID", referencedColumnName = "id")
    @JsonManagedReference
    private Ideologies ideology;

    @OneToOne(mappedBy = "charTable")
    @JsonBackReference
    private CharacterListTable characterListTable;

    public CharacterTable(String name, Integer level, Integer age, Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charisma, Integer hp, Integer addHp, Integer maxHp, Integer classArmor, Integer proficiencyBonus, ClassTable classtable, Genders genders, Race race, Backgrounds background, Ideologies ideology) {
        this.name = name;
        this.level = level;
        this.age = age;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.hp = hp;
        this.addHp = addHp;
        this.maxHp = maxHp;
        this.classArmor = classArmor;
        this.proficiencyBonus = proficiencyBonus;
        this.classtable = classtable;
        this.genders = genders;
        this.race = race;
        this.background = background;
        this.ideology = ideology;
    }

    public CharacterTable() {
    }
}
