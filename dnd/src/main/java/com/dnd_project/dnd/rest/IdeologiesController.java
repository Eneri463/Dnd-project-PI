package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.Ideologies;
import com.dnd_project.dnd.repository.IdeologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IdeologiesController {

    @Autowired
    private IdeologiesRepository ideologiesRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listIdeologies")
    public List<Ideologies> getIdeologyInfo()
    {
        return ideologiesRepository.findAll();
    }

}
