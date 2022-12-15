package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.CharactersInfo;
import com.dnd_project.dnd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private UsersCharactersRepository usersCharactersRepository;
    @Autowired
    private SkillListCharacterRepository skillListCharacterRepository;
    @Autowired
    private SpellListCharacterRepository spellListCharacterRepository;
    @Autowired
    private InventoryListRepository inventoryListRepository;



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterInfo")
    public CharactersInfo getCharacterInfo(@RequestParam Long id)
    {
        return characterRepository.searchCharactersInfo(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteCharacter")
    public ResponseEntity<?> deleteCharacter(@RequestParam Long id)
    {
        try {
            characterRepository.deleteByCharID(id);
            usersCharactersRepository.deleteByCharID(id);
            spellListCharacterRepository.deleteByCharID(id);
            skillListCharacterRepository.deleteByCharID(id);
            inventoryListRepository.deleteByCharID(id);

            return ResponseEntity.ok(id);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

}
