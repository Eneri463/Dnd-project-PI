package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class editCharNameAgeBody {
    private Long id;
    private String charName;
    private Integer age;
}
