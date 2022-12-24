package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.*;
import com.dnd_project.dnd.rest.body.*;
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
    public ResponseEntity<?> deleteCharacter(@RequestBody delElemBody request)
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
    public ResponseEntity<?> createCharacter(@RequestBody createCharBody request) {

        try
        {
            Optional<User> user = userRepository.findByLogin(request.login);
            Backgrounds background = backgroundsRepository.findByIdSpecial(request.charStructure.getBackgroundId());
            ClassTable classTable = classTableRepository.findByIdSpecial(request.charStructure.getClassId());
            Genders genders = genderRepository.findByIdSpecial(request.charStructure.getGendersId());
            Race race = raceRepository.findByIdSpecial(request.charStructure.getRaceId());
            Ideologies ideology = ideologiesRepository.findByIdSpecial(request.charStructure.getIdeologyId());


            CharacterTable NewChar = new CharacterTable(request.charStructure.getCharName(), request.charStructure.getLevel(),
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/editCharacterStats")
    public ResponseEntity<?> editCharStat(@RequestBody editCharStatBody request)
    {
        try
        {
            Optional<CharacterTable> charTable = characterRepository.findById(request.getId());

            if (charTable.isPresent() == true)
            {

                charTable.get().setStrength(request.getStrength());
                charTable.get().setDexterity(request.getDexterity());
                charTable.get().setConstitution(request.getConstitution());
                charTable.get().setIntelligence(request.getIntelligence());
                charTable.get().setWisdom(request.getWisdom());
                charTable.get().setCharisma(request.getCharisma());

                characterRepository.save(charTable.get());

                return ResponseEntity.ok("Ok");
            }
            else
            {
                return new ResponseEntity<>("There is no such character", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/editCharacterHp")
    public ResponseEntity<?> editCharHp(@RequestBody editCharHpBody request)
    {
        try
        {
            Optional<CharacterTable> charTable = characterRepository.findById(request.getId());

            if (charTable.isPresent() == true)
            {

                charTable.get().setAddHp(request.getAddHp());
                charTable.get().setHp(request.getHp());

                characterRepository.save(charTable.get());

                return ResponseEntity.ok("Ok");
            }
            else
            {
                return new ResponseEntity<>("There is no such character", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/editCharacterLevel")
    public ResponseEntity<?> editCharLevel(@RequestBody editCharLevelBody request)
    {
        try
        {
            Optional<CharacterTable> charTable = characterRepository.findById(request.getId());

            if (charTable.isPresent() == true)
            {

                charTable.get().setMaxHp(request.getMaxHp());
                charTable.get().setLevel(request.getLevel());
                charTable.get().setProficiencyBonus(request.getProficiencyBonus());

                characterRepository.save(charTable.get());

                return ResponseEntity.ok("Ok");
            }
            else
            {
                return new ResponseEntity<>("There is no such character", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/editCharacterInfo")
    public ResponseEntity<?> editCharInfo(@RequestBody editCharNameAgeBody request)
    {
        try
        {
            Optional<CharacterTable> charTable = characterRepository.findById(request.getId());

            if (charTable.isPresent() == true)
            {

                charTable.get().setCharName(request.getCharName());
                charTable.get().setAge(request.getAge());

                characterRepository.save(charTable.get());

                return ResponseEntity.ok("Ok");
            }
            else
            {
                return new ResponseEntity<>("There is no such character", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }




}
