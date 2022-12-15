package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.Tracker;
import com.dnd_project.dnd.model.TrackerInfo;
import lombok.Data;

import java.util.List;

@Data
public class TrackerBody {
    public Long id;
    public List<Tracker> t;
}
