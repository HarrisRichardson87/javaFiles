package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GamePlayerService {
    @Autowired
    private  GamePlayerRepository gamePlayerRepository;

    //finds all game players and returns them called from GamePlayer Controller//
    public Set<GamePlayer > getAllGamePlayers(){
        Set<GamePlayer> gameplayers = new HashSet<>();
        gamePlayerRepository.findAll().forEach(gameplayers::add);
        return gameplayers;
    }

//    public void deletePlayer(Long id) {
//        gamePlayerRepository.deleteById(id);
//    }
}