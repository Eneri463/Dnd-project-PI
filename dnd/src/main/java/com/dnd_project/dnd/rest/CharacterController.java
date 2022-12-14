package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.CharactersInfo;
import com.dnd_project.dnd.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterInfo")
    public List<CharactersInfo> getCharacterInfo(@RequestParam Long id)
    {
        return characterRepository.searchCharactersInfo(id);
    }

}
