package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.InventoryListRepository;
import com.dnd_project.dnd.repository.ObjectRepository;
import com.dnd_project.dnd.rest.body.delOrAddObjectBody;
import com.dnd_project.dnd.rest.body.delOrAddSkillBody;
import com.dnd_project.dnd.rest.body.delOrAddSpellBody;
import com.dnd_project.dnd.rest.body.updateObjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InventoryController {

    @Autowired
    private InventoryListRepository inventoryListRepository;

    @Autowired
    private ObjectRepository objectRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterInventory")
    public List<CharInventory> getCharacterInventory(@RequestParam Long id)
    {
        return inventoryListRepository.searchInventory(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listItems")
    public List<ObjectsList> getListObjects()
    {
        return objectRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addCharacterItem")
    public ResponseEntity<?> addObjectChar(@RequestBody delOrAddObjectBody request) {

        try
        {
            Optional<ObjectsList> object = objectRepository.searchObject(request.getObjectId());
            InventoryListCharacter inventoryListCharacter = new InventoryListCharacter(request.getCharId(), object.get());
            inventoryListRepository.save(inventoryListCharacter);

            return ResponseEntity.ok("Ok");
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteCharacterItem")
    public ResponseEntity<?> deleteObjectChar(@RequestParam Long id)
    {
        try {

            inventoryListRepository.deleteByID(id);
            return ResponseEntity.ok("Ok");
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/priorityObject")
    public ResponseEntity<?> updateObjectType(@RequestBody updateObjectType request)
    {
        try
        {
            Optional<InventoryListCharacter> inventory = inventoryListRepository.findById(request.getId());

            if (inventory.isPresent() == true)
            {
                inventory.get().setType(request.getType());
                inventoryListRepository.save(inventory.get());

                return ResponseEntity.ok("Ok");
            }
            else
            {
                return new ResponseEntity<>("No such item", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }
    }





}
