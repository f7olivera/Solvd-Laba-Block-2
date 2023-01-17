package com.solvd.buildingcompany.models.buildings;

public enum BuildingCategory {
    RESIDENTIAL,
    COMMERCIAL,
    INDUSTRIAL,
    OFFICE;

    @Override
    public String toString() {
        // capitalize first letter
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
