package com.codeoftheweb.salvo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
@RestController
@RequestMapping("/api/game_view")
public class GameViewController {


    @Autowired
    private GameRepository repo;
    @Autowired
    private GamePlayerRepository gprepo;

    @JsonIgnore
    @RequestMapping("/{id}")
    public Map<String, Object> getGameByID(@PathVariable Long id) {
        return makeOwnerDTO(gprepo.getOne(id));
    }

    //DTO to return//
    @JsonIgnore
    private Map<String, Object> makeOwnerDTO(GamePlayer owner) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", owner.getGame().getId());
        dto.put("created", owner.getGame().getDate());
        dto.put("gameplayers", owner.getGame().getGamePlayers()
                .stream()
                .map(gp -> gp(gp))
                .collect(Collectors.toList()
                ));
        dto.put("ships", owner.getShips()
                .stream()
                .map(s -> ss(s))
                .collect(Collectors.toSet()));
        return dto;
    }

    @JsonIgnore
    private Map<String, Object> gp(GamePlayer gp) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", gp.getId());
        dto.put("player", gp.getPlayer());
        return dto;
    }

    private Set<Object> getThem(GamePlayer gp) {
        return gp.getShips()
                .stream()
                .map(s -> ss(s))
                .collect(Collectors.toSet());

    }

    private Map<String, Object> ss(Ship ship) {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("type", ship.getType());
        dto.put("locations", makeShipList(ship.getLocations()));
        return dto;
    }
    @JsonIgnore
    private List<Object> makeShipList(Set<ShipLocation> shipSet) {
        return shipSet.stream()
                .map(s -> s.getSpot())
                .collect(Collectors.toList());

    }

}
