package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class CharStructureBody {

    private String charName;
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
    private Long classId;
    private Long gendersId;
    private Long raceId;
    private Long backgroundId;
    private Long ideologyId;

    public CharStructureBody(String name, Integer level, Integer age, Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charisma, Integer hp, Integer addHp, Integer maxHp, Integer classArmor, Integer proficiencyBonus, Long classID, Long gendersID, Long raceID, Long backgroundID, Long ideologyID) {
        this.charName = name;
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
        this.classId = classID;
        this.gendersId = gendersID;
        this.raceId = raceID;
        this.backgroundId = backgroundID;
        this.ideologyId = ideologyID;
    }
}
