package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.Role;
import com.dnd_project.dnd.model.Tracker;
import com.dnd_project.dnd.model.TrackerInfo;
import com.dnd_project.dnd.model.User;
import com.dnd_project.dnd.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

@RestController
public class TrackerController {
    @Autowired
    private TrackerRepository trackerRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getTracker")
    public List<TrackerInfo> getInitiative(@RequestParam Long id) {
        return trackerRepository.showInitiative(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/editTracker")
    public ResponseEntity<?> editTracker(@RequestBody TrackerBody request) {

        /*try
        {
            trackerRepository.deleteByWorldID(id);
            return ResponseEntity.ok(1);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }*/

        try
        {
            try
            {
                trackerRepository.deleteByWorldID(request.getId());
            }
            catch (Exception e)
            {
                return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
            }

            for (int i = 0; i < request.t.size(); i++) {
                Tracker tr = new Tracker(request.id, request.t.get(i).getName(), request.t.get(i).getInitiative(), request.t.get(i).getColor());
                trackerRepository.save(tr);
            }

            return ResponseEntity.ok(request.id);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }

    }


}
