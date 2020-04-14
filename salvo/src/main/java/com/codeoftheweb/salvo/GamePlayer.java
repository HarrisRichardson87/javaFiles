package com.codeoftheweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy="gameplayer", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Ship> ships = new HashSet<>();

//    //Manny games to one GamePlayer
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="player_id")
    private Player player;

    private Date date;

    {
        date = new Date();
    }


    public GamePlayer() {
        this.date = new Date();

    }

    public void setId() {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGames() {
        return game;
    }

    public Date getDate() {
        return date;
    }


    public void setDate(Date date) {
        this.date = date;
    }



    //Add Ship//
    @JsonIgnore
    public void setShips(Ship shipToAdd) {
        shipToAdd.setGameplayer(this);
        ships.add(shipToAdd);
    }
    //Set Ships//
    @JsonIgnore
    public Set<Ship> getShips (){
        return ships;
    }

    //Returns game//
    public Game getOwner() {
        return game;
    }
    //Sets Game
    public void setOwner(Game owner) {
        this.game = owner;
    }
    //Returns Player//
    public Player getPlayer(){
        return player;
    }
    //Sets Player//
    public void setPlayer(Player player){
        this.player = player;
    }

}