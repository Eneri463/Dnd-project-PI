package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class delOrAddConditionBody {
    private Long charId;
    private Long conditionId;
}
