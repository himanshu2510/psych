package com.psych.Game.controller;

import com.psych.Game.model.Player;
import com.psych.Game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dev")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    private  List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping("players/{id}")
    private List<Player> getPlayerById(@PathVariable(value = "id") Long id){
        return playerRepository.findAll();
    }


}
