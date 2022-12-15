package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.UserRepository;
import com.dnd_project.dnd.repository.WorldsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WorldsListController {

    @Autowired
    private WorldsListRepository worldsListRepository;
    @Autowired
    private UserRepository userRepository;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getListWorlds")
    public List<UsersWorlds> getWorldsList(@RequestParam String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return worldsListRepository.searchWorlds(user.get().getId());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createWorld")
    public ResponseEntity<?> newWorld(@RequestBody WorldBody request) {

        try
        {
            Optional<User> user = userRepository.findByLogin(request.login);

            Worlds world = new Worlds(request.name, request.description);


            WorldsLinks NewLinks = new WorldsLinks(user.get().getId(), world);
            WorldsLinks NewListTable = worldsListRepository.save(NewLinks);

            return ResponseEntity.ok(1);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }


}
