package com.softserve.maintenance;

import java.util.List;

public class SparePart {
    private List<Vehicle> vehicles;
    private int number;
    private int cost;
    private String name;

    public void addSparePart(int number){
        this.number += number;
    }

    public void removeSparePart(int number){
        if(number > 0){
            this.number -= number;
        }
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
