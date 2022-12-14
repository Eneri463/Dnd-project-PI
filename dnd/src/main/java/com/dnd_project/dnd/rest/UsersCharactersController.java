package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.CharactersInfo;
import com.dnd_project.dnd.model.User;
import com.dnd_project.dnd.model.UsersCharacters;
import com.dnd_project.dnd.repository.CharacterRepository;
import com.dnd_project.dnd.repository.UserRepository;
import com.dnd_project.dnd.repository.UsersCharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UsersCharactersController {
    @Autowired
    private UsersCharactersRepository usersCharactersRepository;
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getListCharacters")
    public List<UsersCharacters> getCharacterInfo(@RequestParam String login)
    {
        Optional<User> user = userRepository.findByLogin(login);
        return usersCharactersRepository.searchCharacters(user.get().getId());
    }
}
