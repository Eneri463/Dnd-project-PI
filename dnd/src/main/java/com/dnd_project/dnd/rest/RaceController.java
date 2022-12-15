package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.Backgrounds;
import com.dnd_project.dnd.model.Race;
import com.dnd_project.dnd.repository.BackgroundsRepository;
import com.dnd_project.dnd.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RaceController {
    @Autowired
    private RaceRepository raceRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listRaces")
    public List<Race> getRacesInfo()
    {
        return raceRepository.findAll();
    }
}
