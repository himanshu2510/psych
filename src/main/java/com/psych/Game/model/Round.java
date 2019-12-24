package com.psych.Game.model;

import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Entity
@Table(name = "rounds")
public class Round extends Auditable {
    @ManyToOne
    @Getter
    @Setter
    @NotNull
    private Game game;

    @ManyToOne
    @Getter
    @Setter
    private Question question;

    @Getter
    @Setter
    @NotNull
    private int roundNumber;

    @ManyToMany
    @Getter
    @Setter
    private Map<Player,PlayerAnswer> playerAnswers;
}
