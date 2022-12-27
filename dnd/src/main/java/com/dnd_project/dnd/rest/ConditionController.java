package com.dnd_project.dnd.rest;

import com.dnd_project.dnd.model.*;
import com.dnd_project.dnd.repository.ConditionListRepository;
import com.dnd_project.dnd.repository.ConditionRepository;
import com.dnd_project.dnd.rest.body.delOrAddConditionBody;
import com.dnd_project.dnd.rest.body.delOrAddSpellBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ConditionController {

    @Autowired
    private ConditionListRepository conditionListRepository;
    @Autowired
    private ConditionRepository conditionRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/characterConditions")
    public List<CharCondition> getCharactersConditions(@RequestParam Long id)
    {
        return conditionListRepository.searchCondition(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/listConditions")
    public List<ConditionList> getListConditions()
    {
        return conditionRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/addCharacterCondition")
    public ResponseEntity<?> addConditionChar(@RequestBody delOrAddConditionBody request) {

        try
        {
            Optional<ConditionListChar> conditionalList = conditionListRepository.searchCombination(request.getCharId(), request.getConditionId());

            if (conditionalList.isPresent() == false)
            {
                Optional<ConditionList> condition = conditionRepository.searchCondition(request.getConditionId());
                ConditionListChar conditionListChar = new ConditionListChar(request.getCharId(), condition.get());
                conditionListRepository.save(conditionListChar);

                return ResponseEntity.ok(1);
            }
            else
            {
                return new ResponseEntity<>("Character already has this condition", HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("Something went wrong", HttpStatus.BAD_REQUEST);
        }

    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteCharacterCondition")
    public ResponseEntity<?> deleteSpell(@RequestBody delOrAddConditionBody request)
    {
        try {

            conditionListRepository.deleteCondition(request.getCharId(), request.getConditionId());

            return ResponseEntity.ok(1);

        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

}
