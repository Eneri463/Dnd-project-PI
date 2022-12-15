package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.Backgrounds;
import com.dnd_project.dnd.model.Genders;
import com.dnd_project.dnd.repository.BackgroundsRepository;
import com.dnd_project.dnd.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GendersController {

    @Autowired
    private GenderRepository genderRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listGenders")
    public List<Genders> getBackInfo()
    {
        return genderRepository.findAll();
    }

}
