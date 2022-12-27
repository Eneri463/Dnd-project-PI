package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.ClassTable;
import com.dnd_project.dnd.model.Ideologies;
import com.dnd_project.dnd.repository.ClassTableRepository;
import com.dnd_project.dnd.repository.IdeologiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharClassController {

    @Autowired
    private ClassTableRepository classTableRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/listClasses")
    public List<ClassTable> getCInfo()
    {
        return classTableRepository.findAll();
    }

}
