package com.solvd.buildingcompany.models.building.details;

public class BuildingType {
    private int squareMeters;
    private int capacity;
    private int floors;
    private BuildingCategory category;

    public BuildingType(int squareMeters, int capacity, int floors, BuildingCategory category) {
        this.squareMeters = squareMeters;
        this.capacity = capacity;
        this.floors = floors;
        this.category = category;
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
}
