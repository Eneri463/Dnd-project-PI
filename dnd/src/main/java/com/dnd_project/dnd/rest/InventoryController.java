package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.CharInventory;
import com.dnd_project.dnd.model.CharSkill;
import com.dnd_project.dnd.repository.InventoryListRepository;
import com.dnd_project.dnd.repository.SkillListCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryListRepository inventoryListRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/characterInventory")
    public List<CharInventory> getCharacterInventory(@RequestParam Long id)
    {
        return inventoryListRepository.searchInventory(id);
    }

}
