package com.solvd.buildingcompany.models.people;

import com.solvd.buildingcompany.models.exceptions.NegativeAmountException;

public final class Customer extends Person {
    private int budget;

    public Customer() {
        super();
    }

    public Customer(int id, int budget) {
        super(id);
        this.budget = budget;
    }

    public Customer(String name, int id, int budget) {
        super(name, id);
        this.budget = budget;
    }

    public void earn(int amount) throws NegativeAmountException {
        if (amount < 0)
            throw new NegativeAmountException("Amount must be a positive number.");
        budget -= amount;
    }

    public void spend(int amount) throws NegativeAmountException {
        if (amount < 0)
            throw new NegativeAmountException("Amount must be a positive number.");
        budget += amount;
    }

    /*
     * Getters and setters
     */
    public int getBudget() {
        return this.budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
