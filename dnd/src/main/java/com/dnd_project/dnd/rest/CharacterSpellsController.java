package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.CharSpells;
import com.dnd_project.dnd.model.SpellList;
import com.dnd_project.dnd.model.User;
import com.dnd_project.dnd.model.UsersCharacters;
import com.dnd_project.dnd.repository.SpellListCharacterRepository;
import com.dnd_project.dnd.repository.UserRepository;
import com.dnd_project.dnd.repository.UsersCharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class CharacterSpellsController {
    @Autowired
    private SpellListCharacterRepository spellListCharacterRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterSpells")
    public List<CharSpells> getCharactersSpell(@RequestParam Long id)
    {
        return spellListCharacterRepository.searchSpell(id);
    }
}
