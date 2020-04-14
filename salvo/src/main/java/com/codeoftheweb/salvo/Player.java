package com.codeoftheweb.salvo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
@Entity
public class Player {

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private List<GamePlayer> gameplayers = new LinkedList<>();

    public Player(){}

    //Player object constructor//
    public Player(String name) {
        this.id = id;
        this.name = name;
    }

    //Sets player Name//
    public void setName(String name) {
        this.name = name;
    }
    //Gets Name//
    public String getName() {
        return name;
    }
    //Gets ID//
    public Long getId() {
        return id;
    }
    //Sets ID//
    public void setId() {
        this.id = id;
    }

    //Called from GamePlayer ADDS TO LIST//////////////////////////////////////
    public void addGamePlayer(GamePlayer gamePlayer) {
        //Game object is set to this//
        gamePlayer.setPlayer(this);
        //Adds Gamplayer Set into gameplayers repository//
        gameplayers.add(gamePlayer);
    }

    //Returns Gameplayers//
    @JsonIgnore
    public List<GamePlayer> getGamePlayers() { return gameplayers;
    }


}
