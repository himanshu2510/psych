package com.psych.Game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "games")
public class Game extends Auditable{
    @Getter
    @Setter
    @NotNull
    private int numRounds = 0;

    @Getter
    @Setter
    private int currentRound = 0;

    @ManyToMany
    @Getter
    @Setter
    private Map<Player,Stats> playerStatsMap;

    @ManyToMany
    @Getter
    @Setter
    private List<Player> players;

    @NotNull
    @Getter
    @Setter
    private GameMode gameMode;

    @Getter
    @Setter
    private GameStatus gamseStatus = GameStatus.JOINING;

    @ManyToOne
    @NotNull
    @Getter
    @Setter
    private Player leader;

    @OneToMany(mappedBy = "game") // in the round table there will be a game so no need to create another table just use game from the
    //round table.
    @Getter
    @Setter
    private List<Round> rounds;

}
