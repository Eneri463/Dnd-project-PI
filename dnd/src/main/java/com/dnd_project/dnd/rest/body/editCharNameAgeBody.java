package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class editCharNameAgeBody {
    private Long id;
    private String name;
    private Integer age;
}
