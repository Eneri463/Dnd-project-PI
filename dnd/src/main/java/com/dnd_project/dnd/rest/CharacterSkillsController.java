package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.SkillListCharacterRepository;
import com.dnd_project.dnd.repository.SkillRepository;
import com.dnd_project.dnd.rest.body.delOrAddSkillBody;
import com.dnd_project.dnd.rest.body.delOrAddSpellBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CharacterSkillsController {

    @Autowired
    private SkillListCharacterRepository skillListCharacterRepository;
    @Autowired
    private SkillRepository skillRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/characterSkills")
    public List<CharSkill> getCharactersSkills(@RequestParam Long id)
    {
        return skillListCharacterRepository.searchSkills(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listSkills")
    public List<SkillList> getListSkills()
    {
        return skillRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addCharacterSkill")
    public ResponseEntity<?> addSkillChar(@RequestBody delOrAddSkillBody request) {

        try
        {
            Optional<SkillListChar> skillList = skillListCharacterRepository.searchCombination(request.getCharId(), request.getSkillId());

            if (skillList.isPresent() == false)
            {
                Optional<SkillList> skill = skillRepository.searchSkill(request.getSkillId());
                SkillListChar skillListChar = new SkillListChar(request.getCharId(), skill.get());
                skillListCharacterRepository.save(skillListChar);

                return ResponseEntity.ok(1);
            }
            else
            {
                return new ResponseEntity<>("Character already has this skill", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteCharacterSkill")
    public ResponseEntity<?> deleteSkill(@RequestBody delOrAddSkillBody request)
    {
        try {

            skillListCharacterRepository.deleteSkill(request.getCharId(), request.getSkillId());

            return ResponseEntity.ok(1);

        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }


}
