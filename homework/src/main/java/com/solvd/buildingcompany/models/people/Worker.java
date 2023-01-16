package com.solvd.buildingcompany.models.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worker extends Person implements Comparable<Worker> {
    private int employeeId;
    private String position;
    private int salary;
    protected final static Logger LOGGER = LogManager.getLogger(Worker.class);

    public Worker(int employeeId) {
        super();
        this.employeeId = employeeId;
    }

    public Worker(int employeeId, int salary) {
        super();
        this.employeeId = employeeId;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        if (this.hashCode() != obj.hashCode()) return false;

        return employeeId == ((Worker) obj).getEmployeeId();
    }

    @Override
    public int hashCode() {
        return employeeId;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Salary: $%d", salary);
    }

    /*
     * Getters and setters
     */
    public int getEmployeeId() {
        return this.employeeId;
    }

    void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

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

    @Override
    public int compareTo(Worker o) {
        if (salary == o.salary)
            return Integer.compare(employeeId, o.employeeId);

        return Integer.compare(salary, o.salary);
    }
}
