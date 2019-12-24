package com.psych.Game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "content_writers")
public class ContentWriter extends Employee {

    @ManyToMany
    @Getter
    @Setter
    private List<Question> editedQuestion;
}
