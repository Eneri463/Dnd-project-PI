package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class editCharHpBody {
    private Long id;
    private Integer hp;
    private Integer addHp;
}
