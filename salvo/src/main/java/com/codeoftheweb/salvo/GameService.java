package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GameService {
    //wires Game Repo
    @Autowired
    private GameRepository gameRepository;

    //asks to return a game list//
    public List<Game> getAllGames(){
        //Create List to Return//
        List<Game> games = new ArrayList<>();
        //call autowired game repo//
        gameRepository
                .findAll() //find all games in repo
                .forEach(games::add); //add each game to games array list
        return games;
    }

    //asks for a game to be returned//
    public Game getPlayerByGame(Long id) {
        //calls to game repo//
        return gameRepository
                .findById(Long.valueOf(id))//finds by id Game?
                .orElse(null); //else returns null
    }


    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public void updateGame(Long id, Game game) {
        gameRepository.save(game);
    }

    public void deleteGame(Long name) {
        gameRepository.deleteById(name);
    }


}

