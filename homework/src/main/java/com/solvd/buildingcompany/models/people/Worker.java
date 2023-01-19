package com.solvd.buildingcompany.models.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worker extends Person {
    private String position;
    private int salary;
    protected final static Logger LOGGER = LogManager.getLogger(Worker.class);

    public Worker(int id, int salary) {
        super(id);
        this.salary = salary;
    }

    public Worker(String name, int id, int salary) {
        super(name, id);
        this.salary = salary;
    }

    public Worker(String name, int id, String position, int salary) {
        super(name, id);
        this.position = position;
        this.salary = salary;
    }

    public Worker(String name, int age, int id, String position, int salary) {
        super(name, age, id);
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Salary: $%d", salary);
    }

    /*
     * Getters and setters
     */
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
