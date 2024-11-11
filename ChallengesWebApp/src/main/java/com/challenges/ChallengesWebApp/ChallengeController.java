package com.challenges.ChallengesWebApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallenge(),HttpStatus.OK);
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if(isChallengeAdded) {
            return new ResponseEntity<>("Successfully added challenge",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Challenge not added",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge challenge =  challengeService.getChallenge(month);
        if(challenge!=null) {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge updatedChallenge){
        boolean isUpdated = challengeService.updatechallenge(id,updatedChallenge);
        if(isUpdated){
            return new ResponseEntity<>("challenge updated successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("challenge not updated successfully",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if(isChallengeDeleted){
            return new ResponseEntity<>("Challenge is deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Challenge is not deleted successfully",HttpStatus.NOT_FOUND);
        }
    }

}
