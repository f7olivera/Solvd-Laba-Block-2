package com.solvd.buildingcompany.models.building.details;

public class BuildingCost {
    private int costPerSquareMeter;
    private int permitCost;

    public BuildingCost(int costPerSquareMeter, int permitCost) {
        this.costPerSquareMeter = costPerSquareMeter;
        this.permitCost = permitCost;
    }

    public int getCostPerSquareMeter() {
        return costPerSquareMeter;
    }

    public void setCostPerSquareMeter(int costPerSquareMeter) {
        this.costPerSquareMeter = costPerSquareMeter;
    }

    public int getPermitCost() {
        return permitCost;
    }

    public void setPermitCost(int permitCost) {
        this.permitCost = permitCost;
    }
}
