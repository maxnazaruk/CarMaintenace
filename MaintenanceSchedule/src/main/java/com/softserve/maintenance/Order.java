package com.softserve.maintenance;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Order {
    private Vehicle vehicle;
    private List<SparePart> spareParts;
    private int complexity;
    private List<Worker> workers;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private int price;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if(vehicle == null){
            throw new IllegalArgumentException("Vehicle Cannot be null");
        }
        this.vehicle = vehicle;
    }

    public List<SparePart> getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(List<SparePart> spareParts) {
        if(spareParts.size() <= 0){
            throw new IllegalArgumentException("Cannot be zero spare parts");
        }
        this.spareParts = spareParts;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        if(complexity <= 0){
            throw new IllegalArgumentException("Complexity should be in range 1 - 3");
        }
        this.complexity = complexity;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        if(workers.size() <= 0){
            throw new IllegalArgumentException("Work cannot be done without any workers");
        }
        this.workers = workers;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {

        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {

        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price cannot be below zero");
        }
        this.price = price;
    }

    public void checkDates(){
        if(getEndDate().before(getStartDate())){
            throw new IllegalArgumentException("End date cannot goes before Start date");
        }
    }
}
