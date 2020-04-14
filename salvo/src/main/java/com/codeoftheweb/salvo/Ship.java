package com.codeoftheweb.salvo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;


@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private String name;
    private String type;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="gameplayer_id")
    private GamePlayer gameplayer;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="game_id")
    private Game game;

    @ElementCollection
    @Column(name="locations")
    private Set<ShipLocation> locations = new HashSet<>();



    public Ship(){

    }
    public Ship(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

//    public GamePlayer getGameplayer() {
//        return gameplayer;
//    }

    public void setGameplayer(GamePlayer gameplayer) {
        this.gameplayer = gameplayer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ShipLocation> getLocations() {
        return locations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addShipLocation(ShipLocation shipLocationToAdd) {
        locations.add(shipLocationToAdd);
    }







}