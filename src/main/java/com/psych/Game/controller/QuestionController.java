package com.psych.Game.controller;

import com.psych.Game.model.Player;
import com.psych.Game.model.Question;
import com.psych.Game.repository.PlayerRepository;
import com.psych.Game.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dev")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getAllQuestions()
    {
        return questionRepository.findAll();
    }

    @GetMapping("questions/{id}")
    public Question getQuestionById(@PathVariable(value = "id") Long id) throws Exception {
        return questionRepository.findById(id).orElseThrow(Exception::new);
    }


}
