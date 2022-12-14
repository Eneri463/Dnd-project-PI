package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.CharacterInfo;
import com.dnd_project.dnd.model.CharacterTable;
import com.dnd_project.dnd.model.User;
import com.dnd_project.dnd.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findCharacterByID")
    public List<Object[]> getCharacter(@RequestParam String name)

    {
        return characterRepository.findByName(name);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/findSomeInformation")
    public List<CharacterInfo> getCharacterInfo(@RequestParam String name)
    {
        return characterRepository.searchCustom(name);
    }

}
