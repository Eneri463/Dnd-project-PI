package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.Tracker;
import com.dnd_project.dnd.model.TrackerInfo;
import com.dnd_project.dnd.repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

            for (int i = 0; i < request.tracker.size(); i++) {
                Tracker tr = new Tracker(request.id, request.tracker.get(i).getName(), request.tracker.get(i).getInitiative(), request.tracker.get(i).getColor());
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
