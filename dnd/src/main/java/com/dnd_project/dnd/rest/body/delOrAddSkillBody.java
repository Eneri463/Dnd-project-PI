package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class delOrAddSkillBody {
    private Long charId;
    private Long skillId;
}
