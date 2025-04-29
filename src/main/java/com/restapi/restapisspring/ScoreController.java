package com.restapi.restapisspring;

import com.restapi.restapisspring.scores.Scores;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {

    static  Scores scores = new Scores(30,20,10);


    @PutMapping("/scores")
         public Scores replaceAllScore(@RequestBody  Scores newScore){
         scores = newScore;
         return scores;
    }

    @DeleteMapping("/scores")
    public void Deletescore(){
        scores = null;
    }
    @PatchMapping("/scores/wins")
    public Scores  AssignedWins(@RequestParam( name="new-value") int newValue){
        scores.wins = newValue;
        return scores;
    }

    @PostMapping ("/scores/{increaseordecrease}")
    public Scores decreaseorincrease(@PathVariable String increaseordecrease){
        if(increaseordecrease.equalsIgnoreCase("wins")){
            scores.wins++;
            return scores;

        }
        else if(increaseordecrease.equalsIgnoreCase("ties")){
            scores.ties++;
            return scores;
        }
        else {
            scores.looses--;
            return scores;
        }
    }



    @GetMapping("/health-check")
    public String getHealthCheck(){
        return  "Situation on Control";
    }

    @GetMapping("/scores/{getAllinfor}")
    public  int getallinfor(@PathVariable String getAllinfor){
        if(getAllinfor.equalsIgnoreCase("wins")){
            return scores.wins;
        }
        else if(getAllinfor.equalsIgnoreCase("ties")){
            return scores.ties;
        }
        else {
            return scores.looses;
        }
    }

    /*
    @GetMapping("/scores")
    public  Scores getScore(){
        return  scores;
    }
    @GetMapping("/scores/wins")
    public int getScorewins(){
        return scores.wins;
    }

    @GetMapping("/scores/ties")
    public int getScoreTies(){
        return scores.ties;
    }
    @GetMapping("/scores/looses")
    public int getScoreLooses(){
        return scores.looses;
    }

     */
}
