package com.codeoftheweb.salvo;

import javax.persistence.Embeddable;

@Embeddable
public class ShipLocation {
    private String spot;

    public ShipLocation(){};

    public String getSpot() {
        return spot;
    }

    public void setSpot(String spot) {
        this.spot = spot;
    }

    public ShipLocation(String spot) {
        this.spot = spot;
    }
}
