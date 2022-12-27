package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.UserRepository;
import com.dnd_project.dnd.repository.WorldsListRepository;
import com.dnd_project.dnd.repository.WorldsRepository;
import com.dnd_project.dnd.rest.body.editWorldBody;
import com.dnd_project.dnd.rest.body.WorldBody;
import com.dnd_project.dnd.rest.body.delElemBody;
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
    private WorldsRepository worldsRepository;
    @Autowired
    private UserRepository userRepository;


    @CrossOrigin(origins = "*")
    @GetMapping("/getListWorlds")
    public List<UsersWorlds> getWorldsList(@RequestParam String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return worldsListRepository.searchWorlds(user.get().getId());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getWorld")
    public UsersWorld getWorld(@RequestParam Long id) {
                return worldsRepository.searchWorldInfo(id);
    }

    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteWorld")
    public ResponseEntity<?> deleteWorld(@RequestBody delElemBody request)
    {
        try {

            for (int i=0; i<request.id.length; i++)
            {
                worldsRepository.deleteByWorldId(request.id[i]);
                worldsListRepository.deleteByWorldId(request.id[i]);
            }

            return ResponseEntity.ok(request.id.length);

        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/editWorld")
    public ResponseEntity<?> editWorld(@RequestBody editWorldBody request)
    {
        try
        {
            Optional<Worlds> world = worldsRepository.findById(request.id);

           if (world.isPresent() == true)
            {
                world.get().setName(request.name);
                world.get().setDescription(request.description);

                worldsRepository.save(world.get());

                return ResponseEntity.ok(1);
            }
            else
            {
                return new ResponseEntity<>("There is no such world", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }

}
