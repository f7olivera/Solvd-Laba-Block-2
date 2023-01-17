package com.solvd.buildingcompany.dao;

import com.solvd.buildingcompany.models.buildings.Building;
import com.solvd.buildingcompany.models.buildings.BuildingCategory;
import com.solvd.buildingcompany.models.buildings.ConstructionDetails;

import java.util.List;

public interface IBuildingDAO extends IBaseDAO<Building> {
    Building getByName(String name);

    List<Building> getByCategory(BuildingCategory category);

    List<Building> getByDetails(ConstructionDetails details);

    int getBuildingCostId(int costPerSquareMeter, int permitCost);

    int getBuildingTimelineId(int constructionTime, int permitProcessTime);

    int getBuildingTypeId(int capacity, int floors, BuildingCategory category, int squareMeters);
}