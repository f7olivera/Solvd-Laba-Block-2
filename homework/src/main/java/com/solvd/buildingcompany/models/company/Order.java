package com.solvd.buildingcompany.models.company;

import com.solvd.buildingcompany.Main;
import com.solvd.buildingcompany.models.building.Building;
import com.solvd.buildingcompany.models.construction.Construction;
import com.solvd.buildingcompany.models.exceptions.NegativeAmountException;
import com.solvd.buildingcompany.models.people.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Order {
    Customer customer;
    Building building;
    Construction construction;
    boolean is_paid;
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public Order(Customer customer, Building building, Construction construction) {
        this.customer = customer;
        this.building = building;
        this.construction = construction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Construction getConstruction() {
        return construction;
    }

    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    public boolean isPaid() {
        return is_paid;
    }

    public void pay() {
        try {
            customer.spend(building.getTotalCost());
            this.is_paid = true;
        } catch (NegativeAmountException e) {
            LOGGER.info(e.getMessage());
        }
    }
}
