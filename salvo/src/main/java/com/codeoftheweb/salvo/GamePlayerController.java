package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class GamePlayerController {
    @Autowired
    private GamePlayerService gameplayerservice;
    @RequestMapping("/gameplayers")
    public Set<GamePlayer> getAllPlayers(){
        //goes to gameplayer service and calls function which returns a gameplayer list//
        return gameplayerservice.getAllGamePlayers();
    }

//    @RequestMapping("games/{name}")

}
