package com.codeoftheweb.salvo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.List;
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository repo;


//    @JsonIgnore
//    @RequestMapping("/list")
//    public List <Object> getList() {
//        return repo.findAll() //Finds all games in Repo
//                .stream() //allows map or other operations
//                .map(game -> makeOwnerDTO(game)).collect(Collectors.toList());
//    }
//    //DTO to return//
//    @JsonIgnore
//    private Map<String, Object> makeOwnerDTO(Game owner) {
//        Map<String, Object> dto = new LinkedHashMap<String, Object>();
//        dto.put("id", owner.getId());
//        dto.put("created", owner.getDate());
//        dto.put("gameplayers",gp(owner.getGamePlayers()));
//        return dto;
//    }
//    @JsonIgnore






//    public List<Object> makeGamePlayerList(List<GamePlayer> gamePlayer) {
//       return gamePlayer.stream()
//                .map(b -> makeGamePlayerDto(b))
//                .collect(Collectors.toList());
//
//    }
//
//    private Map<String,Object> makeGamePlayerDto(GamePlayer gp) {
//        Map<String,Object> dto = new LinkedHashMap<>();
//        dto.put("id",gp.getId());
//        dto.put("players",gp.getPlayerSet());
//        return dto;
//    }



}

