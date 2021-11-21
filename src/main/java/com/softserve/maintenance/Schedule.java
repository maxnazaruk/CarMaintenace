package com.softserve.maintenance;

import java.text.SimpleDateFormat;
import java.util.*;

public class Schedule {

    private List<Order> orders;
    private int view;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public void removeFromOrders(Order order){
        this.orders.remove(order);
    }

    public void sortByStartDate(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getStartDate().compareTo(o2.getStartDate());
            }
        });
    }

    public void sortByComplexity(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getComplexity() - o2.getComplexity();
            }
        });
    }

    public void sortByWorkers(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getWorkers().size() - o2.getWorkers().size();
            }
        });
    }

    public void sortByEndDate(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getEndDate().compareTo(o2.getEndDate());
            }
        });
    }

    public void sortByPrice(){
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }
}
