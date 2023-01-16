package com.solvd.buildingcompany.models.people;

public class Person {
    private String name;
    private int age;
    private int id;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n", name) +
                String.format("Age: %d\n", age) +
                String.format("ID: %d\n", id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        if (this.hashCode() != obj.hashCode()) return false;

        return id == ((Person) obj).getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

    /*
     * Getters and setters
     */
    public String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return this.id;
    }

    void setId(int id) {
        this.id = id;
    }
}
