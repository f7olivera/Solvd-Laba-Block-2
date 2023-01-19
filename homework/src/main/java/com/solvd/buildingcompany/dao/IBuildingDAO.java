package com.solvd.buildingcompany.dao;

import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.details.BuildingCategory;

import java.util.List;

public interface IBuildingDAO extends IBaseDAO<Building> {
    Building getByName(String name);

    List<Building> getByCategory(BuildingCategory category);

    int getBuildingCostId(int costPerSquareMeter, int permitCost);

    int getBuildingTimelineId(int constructionTime, int permitProcessTime);

    int getBuildingTypeId(int capacity, int floors, BuildingCategory category, int squareMeters);
}
