package com.psych.Game.repository;

import com.psych.Game.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> { //this is used to provide searching updating retrieving functionalities to the player
    //table

}
