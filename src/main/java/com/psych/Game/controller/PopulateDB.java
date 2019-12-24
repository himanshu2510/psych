package com.psych.Game.controller;

import com.psych.Game.Constants;
import com.psych.Game.Pair;
import com.psych.Game.Utils;
import com.psych.Game.model.GameMode;
import com.psych.Game.model.Player;
import com.psych.Game.model.Question;
import com.psych.Game.repository.PlayerRepository;
import com.psych.Game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dev")
public class PopulateDB {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/add-question-from-file")
    private  void AddQuestionsFromFiles() throws FileNotFoundException {
        //i need to read questions file and populate db
        //before adding questions again make sure that you delete all the questions in the db first
        questionRepository.deleteAll();
        for(Map.Entry<String,GameMode> entry: Constants.QA_FILES.entrySet()){
            int questionNumber = 0;
            String fileName = entry.getKey();
            GameMode gameMode = entry.getValue();
            for(Pair<String,String> question_answer: Utils.readQAFile(fileName)){
                Question q = new Question();
                q.setQuestionText(question_answer.getFirst());
                q.setCorrectAnswer(question_answer.getSecond());
                q.setGameMode(gameMode);
                questionRepository.save(q);
                ++questionNumber;
                if(questionNumber > Constants.MAX_QUESTIONS_TO_READ){
                    break;
                }
            }
        }
    }


    @GetMapping("/add-dummy-players")
    private  void addDummyPlayers() throws FileNotFoundException {
        //same as add-questions-from-file
        playerRepository.deleteAll();
        Player luffy = new Player();
        luffy.setName("Monkey D. Luffy");

        Player robin = new Player();
        robin.setName("Nico Robin");

        playerRepository.save(luffy);
        playerRepository.save(robin);
    }


}
