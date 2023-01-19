package com.solvd.buildingcompany.models.construction;

import com.solvd.buildingcompany.models.people.Worker;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Construction {
    private String address;
    private ConstructionState state = ConstructionState.PLANNED;
    private Date startDate;
    private Date endDate;
    private Set<Worker> workers;
    private Map<Item, Integer> items;

    public Construction(String address, Date startDate, Set<Worker> workers) {
        this.address = address;
        this.startDate = startDate;
        this.workers = workers;
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

    public Map<Item, Integer> getItems() {
        return items;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void setItems(Map<Item, Integer> items) {
        this.items = items;
    }

    public void addItem(Item item, int amount) {
        items.put(item, amount);
    }
}
