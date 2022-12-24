package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class editCharStatBody {
    private Long id;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
}
