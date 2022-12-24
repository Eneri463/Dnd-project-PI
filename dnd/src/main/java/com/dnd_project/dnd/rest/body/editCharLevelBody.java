package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class editCharLevelBody {

    private Long id;
    private Integer level;
    private Integer maxHp;
    private Integer proficiencyBonus;
}
