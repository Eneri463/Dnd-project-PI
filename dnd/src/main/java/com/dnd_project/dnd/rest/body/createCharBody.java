package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class createCharBody {
    public String login;
    public CharStructureBody charStructure;
}