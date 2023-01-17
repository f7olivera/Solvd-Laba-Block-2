package com.solvd.buildingcompany.models.construction;

import java.util.Date;
import java.util.Set;

public class Construction {
    private String address;
    private ConstructionState state = ConstructionState.PLANNED;
    private Date startDate;
    private Date endDate;
    private Set<Item> items;

    public Construction(String address, Date startDate, Set<Item> items) {
        this.address = address;
        this.startDate = startDate;
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ConstructionState getState() {
        return state;
    }

    public void setState(ConstructionState state) {
        this.state = state;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
