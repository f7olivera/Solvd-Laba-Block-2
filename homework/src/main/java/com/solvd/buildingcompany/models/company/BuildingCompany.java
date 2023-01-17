package com.solvd.buildingcompany.models.company;

import com.solvd.buildingcompany.models.people.Worker;

import java.util.Set;

public class BuildingCompany {
    private String name;
    private Set<Worker> workers;
    private Set<Order> orders;

    public BuildingCompany(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void removeWorker(Worker worker) {
        workers.remove(worker);
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
