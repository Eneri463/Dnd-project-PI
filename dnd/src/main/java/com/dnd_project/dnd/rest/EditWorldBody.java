package com.dnd_project.dnd.rest;

import lombok.Data;

@Data
public class EditWorldBody {
    Long id;
    String name;
    String description;
}
