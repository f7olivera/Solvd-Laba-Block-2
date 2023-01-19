package com.solvd.buildingcompany.dao.mysql;

import com.solvd.buildingcompany.dao.IBuildingDAO;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.building.details.BuildingCategory;
import com.solvd.buildingcompany.models.building.details.BuildingCost;
import com.solvd.buildingcompany.models.building.details.BuildingTimeline;
import com.solvd.buildingcompany.models.building.details.BuildingType;
import com.solvd.buildingcompany.models.construction.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuildingDAO extends MySQLDAO implements IBuildingDAO {
    private final static Logger LOGGER = LogManager.getLogger(BuildingDAO.class);

    public BuildingDAO() throws SQLException {
        super();
    }

    @Override
    public Building create(Building building) throws SQLException {
        BuildingCost cost = building.getCost();
        BuildingTimeline timeline = building.getTimeline();
        BuildingType type = building.getType();

        LOGGER.info("Creating " + type.getCategory() + " building.");

        // Searching costId, timelineId and typeId will create them if they don't exist
        int costId = getBuildingCostId(cost.getCostPerSquareMeter(), cost.getPermitCost());
        int timelineId = getBuildingTimelineId(timeline.getConstructionTime(), timeline.getPermitProcessTime());
        int typeId = getBuildingTypeId(type.getCapacity(), type.getFloors(), type.getCategory(), type.getSquareMeters());

        String sql = "INSERT INTO Buildings (name, building_cost_id, building_timeline_id, building_type_id)" +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, building.getName());
        statement.setInt(2, costId);
        statement.setInt(3, timelineId);
        statement.setInt(4, typeId);
        statement.executeUpdate();

        ResultSet keys = statement.getGeneratedKeys();
        int generatedId = 0;
        if (keys.next()) {
            generatedId = keys.getInt(1);
        }

        String itemQuery = "INSERT INTO BuildingItems (building_id, item_id) VALUES (?, SELECT id FROM Items WHERE name = ? AND price = ?)";
        PreparedStatement itemStatement = connection.prepareStatement(itemQuery);
        itemStatement.setInt(1, generatedId);
        for (Item item : building.getRequiredItems()) {
            itemStatement.setString(2, item.getName());
            itemStatement.setDouble(3, item.getPrice());
            itemStatement.executeUpdate();
        }
        return building;
    }

    @Override
    public Building get(int id) {
        LOGGER.info("Finding building by id " + id + ".");
        // TODO
        return null;
    }

    @Override
    public Building update(Building building) {
        LOGGER.info("Updating building " + building.getName() + ".");
        // TODO
        return building;
    }

    @Override
    public void delete(int id) {
        LOGGER.info("Deleting building with id " + id + ".");
        // TODO
    }

    @Override
    public List<Building> findAll() {
        LOGGER.info("Finding all buildings.");
        // TODO
        return new ArrayList<>();
    }

    @Override
    public int count() {
        LOGGER.info("Counting buildings.");
        // TODO
        return 0;
    }

    @Override
    public Building getByName(String name) {
        return null;
    }

    @Override
    public List<Building> getByCategory(BuildingCategory category) {
        return null;
    }


    @Override
    public int getBuildingCostId(int costPerSquareMeter, int permitCost) {
        try {
            String query = "INSERT INTO Building_Costs (cost_per_square_meter, permit_cost)\n" +
                    String.format("VALUES (%d, %d)\n", costPerSquareMeter, permitCost) +
                    "ON DUPLICATE KEY UPDATE id = LAST_INSERT_ID(id);";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                return resultSet.getInt(1);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return -1;
    }

    @Override
    public int getBuildingTimelineId(int constructionTime, int permitProcessTime) {
        return 0;
    }

    @Override
    public int getBuildingTypeId(int capacity, int floors, BuildingCategory category, int squareMeters) {
        return 0;
    }
}
