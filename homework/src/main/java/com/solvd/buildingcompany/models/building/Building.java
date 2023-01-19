package com.solvd.buildingcompany.models.building;

import com.solvd.buildingcompany.models.building.details.BuildingCost;
import com.solvd.buildingcompany.models.building.details.BuildingTimeline;
import com.solvd.buildingcompany.models.building.details.BuildingType;
import com.solvd.buildingcompany.models.construction.Item;

import java.util.Set;

public class Building {
    private String name;
    private BuildingCost cost;
    private BuildingTimeline timeline;
    private BuildingType type;
    private Set<Item> requiredItems;

    public Building(String name, BuildingCost cost, BuildingTimeline timeline, BuildingType type) {
        this.name = name;
        this.cost = cost;
        this.timeline = timeline;
        this.type = type;
    }

    public int getTotalCost() {
        return cost.getCostPerSquareMeter() * type.getSquareMeters()
                + cost.getPermitCost()
                + requiredItems.stream().mapToInt(Item::getPrice).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuildingCost getCost() {
        return cost;
    }

    public void setCost(BuildingCost cost) {
        this.cost = cost;
    }

    public BuildingTimeline getTimeline() {
        return timeline;
    }

    public void setTimeline(BuildingTimeline timeline) {
        this.timeline = timeline;
    }

    public BuildingType getType() {
        return type;
    }

    public void setType(BuildingType type) {
        this.type = type;
    }

    public Set<Item> getRequiredItems() {
        return requiredItems;
    }

    public void setRequiredItems(Set<Item> requiredItems) {
        this.requiredItems = requiredItems;
    }
}
