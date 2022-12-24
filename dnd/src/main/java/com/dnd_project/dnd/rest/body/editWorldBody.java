package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class editWorldBody {
    public Long id;
    public String worldName;
    public String description;
}
