package com.solvd.buildingcompany.models.building.details;

public class BuildingTimeline {
    private int constructionTime;
    private int permitProcessTime;

    public BuildingTimeline(int constructionTime, int permitProcessTime) {
        this.constructionTime = constructionTime;
        this.permitProcessTime = permitProcessTime;
    }

    public int getConstructionTime() {
        return constructionTime;
    }

    public void setConstructionTime(int constructionTime) {
        this.constructionTime = constructionTime;
    }

    public int getPermitProcessTime() {
        return permitProcessTime;
    }

    public void setPermitProcessTime(int permitProcessTime) {
        this.permitProcessTime = permitProcessTime;
    }
}
