package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameService gameService;
    @RequestMapping("/games")
    public List<Game> getAllPlayers(){
        return gameService.getAllGames();
    }
    @RequestMapping("games/{id}")
    public Game getAllGames(){
        return (Game) gameService.getAllGames();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/games")
    public void addGame(@RequestBody Game game){
        gameService.addGame(game);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/games/{id}")
    public void updatePlayer(@RequestBody Game game, @PathVariable Long id){
        gameService.updateGame(id,game);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/games/{id}")
    public void deleteGame(@PathVariable Long id){
        gameService.deleteGame(id);
    }

}