package com.solvd.buildingcompany.models.buildings;

public class Building {
    private String name;
    private ConstructionDetails details;

    public Building(String name, ConstructionDetails constructionDetails) {
        this.name = name;
        this.details = constructionDetails;
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
