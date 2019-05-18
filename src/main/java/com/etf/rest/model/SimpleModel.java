package com.etf.rest.model;

public class SimpleModel {
    private double id;
    private String name;
    private String description;
    private boolean active;
    private double amount;

    public SimpleModel() {
    }

    public SimpleModel(double id, String name, String description, boolean active, double amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.amount = amount;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
