package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class InitiativeBody {
    private String charName;
    private Double initiative;
    private String color;
}
