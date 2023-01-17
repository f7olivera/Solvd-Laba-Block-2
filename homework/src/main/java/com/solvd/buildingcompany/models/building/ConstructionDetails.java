package com.solvd.buildingcompany.models.building;

import com.solvd.buildingcompany.models.construction.Item;

import java.util.Set;

public class ConstructionDetails {
    private int costPerSquareMeter;
    private int permitCost;
    private int constructionTime;
    private int permitProcessTime;
    private int squareMeters;
    private int capacity;
    private int floors;
    private BuildingCategory category;
    private Set<Item> requiredItems;

    public ConstructionDetails(int costPerSquareMeter, int permitCost, int constructionTime,
                               int permitProcessTime, int squareMeters, int capacity, int floors,
                               BuildingCategory category, Set<Item> requiredItems) {
        this.costPerSquareMeter = costPerSquareMeter;
        this.permitCost = permitCost;
        this.constructionTime = constructionTime;
        this.permitProcessTime = permitProcessTime;
        this.squareMeters = squareMeters;
        this.capacity = capacity;
        this.floors = floors;
        this.category = category;
        this.requiredItems = requiredItems;
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

    public int getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(int squareMeters) {
        this.squareMeters = squareMeters;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public BuildingCategory getCategory() {
        return category;
    }

    public void setCategory(BuildingCategory category) {
        this.category = category;
    }

    public Set<Item> getRequiredItems() {
        return requiredItems;
    }

    public void setRequiredItems(Set<Item> requiredItems) {
        this.requiredItems = requiredItems;
    }
}