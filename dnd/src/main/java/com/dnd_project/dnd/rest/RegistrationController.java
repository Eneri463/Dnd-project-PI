package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.User;
import com.dnd_project.dnd.repository.UserRepository;
import com.dnd_project.dnd.rest.body.AuthenticationBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/registration")
    public ResponseEntity<?> Registration(@RequestBody AuthenticationBody request)
    {
        try {
            boolean flag = userRepository.findByLogin(request.getLogin()) != null ? true : false;

            if (flag) {
                User user = new User(request.getLogin(), BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));

                Map<Object, Object> response = new HashMap<>();

                response.put("login", request.getLogin());
                response.put("password", request.getPassword());

                userRepository.save(user);

                return ResponseEntity.ok(response);
            } else {
                return new ResponseEntity<>("This login already exists", HttpStatus.FORBIDDEN);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Something went wrong",HttpStatus.FORBIDDEN);
        }
    }
}
