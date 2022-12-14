package com.dnd_project.dnd.model;

public interface CharacterInfo {
    Integer getId();
    String getName();
    String getAge();
    String getClassname();

    public interface ClassTable {
        String getClassname();
    }
}
