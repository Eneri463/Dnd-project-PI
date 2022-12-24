package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassTableRepository classTableRepository;
    @Autowired
    private BackgroundsRepository backgroundsRepository;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private IdeologiesRepository ideologiesRepository;

    @Autowired
    private GenderRepository genderRepository;



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterInfo")
    public CharactersInfo getCharacterInfo(@RequestParam Long id)
    {
        return characterRepository.searchCharactersInfo(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteCharacter")
    public ResponseEntity<?> deleteCharacter(@RequestBody delBody request)
    {
        try {

            for (int i=0; i<request.id.length; i++)
            {
                characterRepository.deleteByCharID(request.id[i]);
                usersCharactersRepository.deleteByCharID(request.id[i]);
                spellListCharacterRepository.deleteByCharID(request.id[i]);
                skillListCharacterRepository.deleteByCharID(request.id[i]);
                inventoryListRepository.deleteByCharID(request.id[i]);
            }

            return ResponseEntity.ok(request.id.length);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createCharacter")
    public ResponseEntity<?> createCharacter(@RequestBody CreateCharBody request) {

        try
        {
            Optional<User> user = userRepository.findByLogin(request.login);
            Backgrounds background = backgroundsRepository.findByIdSpecial(request.charStructure.getBackgroundID());
            ClassTable classTable = classTableRepository.findByIdSpecial(request.charStructure.getClassID());
            Genders genders = genderRepository.findByIdSpecial(request.charStructure.getGendersID());
            Race race = raceRepository.findByIdSpecial(request.charStructure.getRaceID());
            Ideologies ideology = ideologiesRepository.findByIdSpecial(request.charStructure.getIdeologyID());


            CharacterTable NewChar = new CharacterTable(request.charStructure.getName(), request.charStructure.getLevel(),
                    request.charStructure.getAge(), request.charStructure.getStrength(),
                    request.charStructure.getDexterity(), request.charStructure.getConstitution(), request.charStructure.getIntelligence(),
                    request.charStructure.getWisdom(), request.charStructure.getCharisma(),request.charStructure.getHp(),
                    request.charStructure.getAddHp(), request.charStructure.getMaxHp(), request.charStructure.getClassArmor(),
                    request.charStructure.getProficiencyBonus(), classTable, genders, race, background, ideology);


            CharacterListTable NewList = new CharacterListTable(user.get().getId(), NewChar);
            CharacterListTable NewListTable = usersCharactersRepository.save(NewList);


            return ResponseEntity.ok(1);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }




}
