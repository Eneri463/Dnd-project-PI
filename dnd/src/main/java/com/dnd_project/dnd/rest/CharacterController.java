package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createCharacter")
    public ResponseEntity<?> editTracker(@RequestBody CreateCharBody request) {

        System.out.println("Здесь");
        try
        {
            Optional<User> user = userRepository.findByLogin(request.login);
            System.out.println("Здесь1");
            Backgrounds background = backgroundsRepository.findByIdSpecial(request.charStructure.getBackgroundID());
            System.out.println("Здесь2");
            ClassTable classTable = classTableRepository.findByIdSpecial(request.charStructure.getClassID());
            System.out.println("Здесь3");
            Genders genders = genderRepository.findByIdSpecial(request.charStructure.getGendersID());
            System.out.println("Здесь4");
            Race race = raceRepository.findByIdSpecial(request.charStructure.getRaceID());
            System.out.println("Здесь5");
            Ideologies ideology = ideologiesRepository.findByIdSpecial(request.charStructure.getIdeologyID());
            System.out.println("Здесь6");

            CharacterTable NewChar = new CharacterTable(request.charStructure.getName(), request.charStructure.getLevel(),
                    request.charStructure.getAge(), request.charStructure.getStrength(),
                    request.charStructure.getDexterity(), request.charStructure.getConstitution(), request.charStructure.getIntelligence(),
                    request.charStructure.getWisdom(), request.charStructure.getCharisma(),request.charStructure.getHp(),
                    request.charStructure.getAddHp(), request.charStructure.getMaxHp(), request.charStructure.getClassArmor(),
                    request.charStructure.getProficiencyBonus(), classTable, genders, race, background, ideology);



            System.out.println("Здесь");
            //CharacterTable NewChar = characterRepository.save(request.charStructure);


            //CharacterTable NewCharTable = characterRepository.save(NewChar);

            CharacterListTable NewList = new CharacterListTable(user.get().getId(), NewChar);
            CharacterListTable NewListTable = usersCharactersRepository.save(NewList);

            /*CharacterTable NewCharTable = characterRepository.saveSpecial(request.charStructure.getName(), request.charStructure.getLevel(),
                    request.charStructure.getAge(), request.charStructure.getStrength(), request.charStructure.getDexterity(),
                    request.charStructure.getConstitution(), request.charStructure.getIntelligence(), request.charStructure.getWisdom(),
                    request.charStructure.getCharisma(), request.charStructure.getClassID(),
                    request.charStructure.getGendersID(), request.charStructure.getRaceID(),
                    request.charStructure.getBackgroundID(), request.charStructure.getIdeologyID());*/

            return ResponseEntity.ok(1);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }


}
