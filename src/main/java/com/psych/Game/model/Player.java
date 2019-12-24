package com.psych.Game.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.ServerEndpoint;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "players")
public class Player extends Auditable { //the one object of player represents one row in the table

    @Getter
    @Setter
    @NotBlank
    private String name;

    @Getter
    @Setter
    @URL
    private String psychFaceURL;

    @Getter
    @Setter
    @URL
    private String picURL;

    @OneToOne
    @Getter
    @Setter
    private Stats stats;

    @ManyToMany(mappedBy = "players")
    @Getter
    @Setter
    private List<Game> games;


}
