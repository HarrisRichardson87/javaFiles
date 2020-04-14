package com.codeoftheweb.salvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
public class PlayerController {

    @Autowired
    //Wired to all functions in player service//
    private PlayerService playerService;

    @RequestMapping("/players")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }
    @RequestMapping("players/{id}")
    public Player getPlayerByID(@PathVariable Long id){
           return playerService.getPlayerById(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/players")
    public void addPlayer(@RequestBody Player player){
            playerService.addPlayer(player);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/players/{id}")
    public void updatePlayer(@RequestBody Player player, @PathVariable Long id){
        playerService.updatePlayer(id,player);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/players/{id}")
    public void deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
    }

}