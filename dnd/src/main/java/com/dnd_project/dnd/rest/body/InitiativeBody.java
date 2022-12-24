package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class InitiativeBody {
    private String name;
    private Double initiative;
    private String color;
}
