package com.dnd_project.dnd.rest.body;

import lombok.Data;

import java.util.List;

@Data
public class TrackerBody {
    public Long id;
    public List<InitiativeBody> tracker;
}
