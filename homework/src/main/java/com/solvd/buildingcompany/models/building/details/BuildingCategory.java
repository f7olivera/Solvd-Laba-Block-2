package com.solvd.buildingcompany.models.building.details;

public enum BuildingCategory {
    RESIDENTIAL,
    COMMERCIAL,
    INDUSTRIAL,
    OFFICE;

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
