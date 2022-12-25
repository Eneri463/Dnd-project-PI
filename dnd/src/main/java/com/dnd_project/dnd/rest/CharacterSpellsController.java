package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.SpellListCharacterRepository;
import com.dnd_project.dnd.repository.SpellRepository;
import com.dnd_project.dnd.rest.body.delOrAddSpellBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CharacterSpellsController {
    @Autowired
    private SpellListCharacterRepository spellListCharacterRepository;
    @Autowired
    private SpellRepository spellRepository;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterSpells")
    public List<CharSpells> getCharactersSpell(@RequestParam Long id)
    {
        return spellListCharacterRepository.searchSpells(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listSpells")
    public List<SpellList> getListSpell()
    {
        return spellRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addCharacterSpell")
    public ResponseEntity<?> addSpellChar(@RequestBody delOrAddSpellBody request) {

        try
        {
            Optional<SpellListChar> spellList = spellListCharacterRepository.searchCombination(request.getCharId(), request.getSpellId());

            if (spellList.isPresent() == false)
            {
                Optional<SpellList> spell = spellRepository.searchSpell(request.getSpellId());
                SpellListChar spellListChar = new SpellListChar(request.getCharId(), spell.get());
                spellListCharacterRepository.save(spellListChar);

                return ResponseEntity.ok(1);
            }
            else
            {
                return new ResponseEntity<>("Character already has this spell", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteCharacterSpell")
    public ResponseEntity<?> deleteSpell(@RequestBody delOrAddSpellBody request)
    {
        try {

            spellListCharacterRepository.deleteSpell(request.getCharId(), request.getSpellId());

            return ResponseEntity.ok(1);

        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }


}
