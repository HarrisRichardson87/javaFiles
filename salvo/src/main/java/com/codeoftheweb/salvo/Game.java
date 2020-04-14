package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;

    Date date = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy="game", fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<GamePlayer> gameplayers = new HashSet<>();
//
//    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set <Ship> ships;

//    public Set<Ship> getShips() {
//        return ships;
//    }
//
//    public void setShips(Set<Ship> ships) {
//        this.ships = ships;
//    }

    public Game() { }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public Game(String name) {
        this.name = name;
        this.date = new Date();
        this.id = id;


    }

    //Name/////////////////////////////////////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Called from GamePlayer ADDS TO LIST//////////////////////////////////////
    public void addGamePlayer(GamePlayer gamePlayer) {
        //Game object is set to this//
        gamePlayer.setOwner(this);
        //Adds Gamplayer Set into gameplayers repository//
        gameplayers.add(gamePlayer);
    }

    @JsonIgnore
    public Set<GamePlayer> getGamePlayers() { return gameplayers;
    }

}