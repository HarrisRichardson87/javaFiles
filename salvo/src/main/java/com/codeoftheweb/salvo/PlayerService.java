package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private  PlayerRepository playerRepository;

    //returns a list of all players//
    public List<Player> getAllPlayers(){
      List<Player> players = new ArrayList<>();//defines an array list players to return
      playerRepository //calls player repository of all players saved
              .findAll() //finds all available
              .forEach(players::add); //adds each player to players array

        return players; //returns array list of players
  }

    //return player object found by ID//
    public Player getPlayerById(Long id) {
        return playerRepository //pulls up repository of Players saved
                .findById(id) //finds player by ID called
                .orElse(null);//if not return null
    }

    //adds player to repository
    public void addPlayer(Player player) {
      playerRepository.save(player);//saves called player
    }

    //updates player by id and new Player to replace
    public void updatePlayer(Long id, Player player) {
      playerRepository.save(player);
    }

    //deletes Player by ID
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
