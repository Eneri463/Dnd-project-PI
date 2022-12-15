package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.ClassTable;
import com.dnd_project.dnd.model.Role;
import com.dnd_project.dnd.model.User;
import com.dnd_project.dnd.repository.ClassTableRepository;
import com.dnd_project.dnd.repository.UserRepository;
import com.dnd_project.dnd.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationBody request)
    {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
            User user = userRepository.findByLogin(request.getLogin()).orElseThrow(()->new UsernameNotFoundException("User doesn't exists"));
            String token = jwtTokenProvider.createToken(request.getLogin(), Role.USER.name());
            Map<Object, Object> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);
        }
        catch(AuthenticationException e)
        {
            return new ResponseEntity<>("Invalid login/password", HttpStatus.FORBIDDEN);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response)
    {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request,response,null);
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<?> userInfo(@RequestParam String login)
    {
        try {

            User user = userRepository.findByLogin(login).orElseThrow();
            Map<Object, Object> response = new HashMap<>();
            response.put("login", user.getLogin());
            return ResponseEntity.ok(response);

        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public static class CharClassController {
        @Autowired
        private ClassTableRepository classTableRepository;

        @CrossOrigin(origins = "http://localhost:4200")
        @GetMapping("/listClasses")
        public List<ClassTable> getClassesInfo()
        {
            return classTableRepository.findAll();
        }
    }
}
