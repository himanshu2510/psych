package com.psych.Game.model;

import com.psych.Game.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question extends Auditable {
    @Getter
    @Setter
    @NotBlank
    @Column(length = Constants.MAX_QUESTION_LENGTH) //default length of question text column is 255 i want the length of the question text column to be of 1000 so
    //it can accomodate longer questions as well if need be
    private String questionText;

    @Getter
    @Setter
    @NotBlank
    @Column(length = Constants.MAX_ANSWER_LENGTH)
    private String correctAnswer;

    @NotNull
    @Getter
    @Setter
    private GameMode gameMode;

    @OneToMany(mappedBy = "question")
    @Getter
    @Setter
    private List<EllenAnswer> ellenAnswers;
}
