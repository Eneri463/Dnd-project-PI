package com.dnd_project.dnd.rest;

import lombok.Data;

@Data
public class CharStructure {

    private String name;
    private Integer level;
    private Integer age;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private Integer hp;
    private Integer addHp;
    private Integer maxHp;
    private Integer classArmor;
    private Integer proficiencyBonus;
    private Long classID;
    private Long gendersID;
    private Long raceID;
    private Long backgroundID;
    private Long ideologyID;

    public CharStructure(String name, Integer level, Integer age, Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charisma, Integer hp, Integer addHp, Integer maxHp, Integer classArmor, Integer proficiencyBonus, Long classID, Long gendersID, Long raceID, Long backgroundID, Long ideologyID) {
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
        this.classID = classID;
        this.gendersID = gendersID;
        this.raceID = raceID;
        this.backgroundID = backgroundID;
        this.ideologyID = ideologyID;
    }
}
