package com.solvd.buildingcompany.models.building;

import com.solvd.buildingcompany.models.construction.Item;

public class Building {
    private String name;
    private ConstructionDetails details;

    public Building(String name, ConstructionDetails constructionDetails) {
        this.name = name;
        this.details = constructionDetails;
    }

    public int getCost() {
        return details.getCostPerSquareMeter() * details.getSquareMeters()
                + details.getPermitCost()
                + details.getRequiredItems().stream().mapToInt(Item::getPrice).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConstructionDetails getDetails() {
        return details;
    }

    public void setDetails(ConstructionDetails details) {
        this.details = details;
    }
}
