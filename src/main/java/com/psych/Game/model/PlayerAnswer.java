package com.psych.Game.model;

import com.psych.Game.Constants;
import javafx.scene.media.AudioTrack;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "player_answers")
public class PlayerAnswer extends Auditable {

    @Getter
    @Setter
    @NotBlank
    @Column(length = Constants.MAX_QUESTION_LENGTH)
    private String answer;

    @Getter
    @Setter
    private Round round;

    @Getter
    @Setter
    @NotNull
    private Player player;
}
