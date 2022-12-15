package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.CharSkill;
import com.dnd_project.dnd.model.CharSpells;
import com.dnd_project.dnd.repository.SkillListCharacterRepository;
import com.dnd_project.dnd.repository.SpellListCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterSkillsController {

    @Autowired
    private SkillListCharacterRepository skillListCharacterRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterSkills")
    public List<CharSkill> getCharactersSpell(@RequestParam Long id)
    {
        return skillListCharacterRepository.searchSkill(id);
    }

}
