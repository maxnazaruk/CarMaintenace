package com.softserve.maintenance;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScheduleTest {

    Schedule schedule = new Schedule();

    @BeforeEach
    void init() {
        // Create a test list of orders
        Order order = new Order();
        order.setComplexity(1);

        // Set Date Format
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MMM dd");
        order.setEndDate(new GregorianCalendar(2021, 5, 10));
        order.setPrice(100);
        order.setStartDate(new GregorianCalendar(2021, 5, 5));
        order.setVehicle(new Vehicle());

        // Create Workers
        Worker mainWorker = new Worker();
        Worker subWorker = new Worker();
        Worker intern = new Worker();

        List<Worker> workerList = new ArrayList<Worker>();
        workerList.add(mainWorker);
        workerList.add(subWorker);
        workerList.add(intern);

        order.setWorkers(workerList);

        // Create a list of Spare parts
        List<SparePart> spareParts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            spareParts.add(new SparePart());
        }
        order.setSpareParts(spareParts);
        //====================================================================================
        Order orderNext = new Order();
        orderNext.setComplexity(6);

        // Set Date Format
        orderNext.setEndDate(new GregorianCalendar(2021, 10, 20));
        orderNext.setPrice(200);
        orderNext.setStartDate(new GregorianCalendar(2021, 10, 10));
        orderNext.setVehicle(new Vehicle());

        List<Worker> workerListNext = new ArrayList<Worker>();

        workerListNext.add(mainWorker);
        workerListNext.add(subWorker);

        orderNext.setWorkers(workerListNext);

        // Create a list of Spare parts
        spareParts.clear();
        for (int i = 0; i < 5; i++) {
            spareParts.add(new SparePart());
        }
        orderNext.setSpareParts(spareParts);

        // Create a list of Spare parts
        List<SparePart> sparePartsNext = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            sparePartsNext.add(new SparePart());
        }
        order.setSpareParts(sparePartsNext);
        //====================================================================================
        Order orderBefore = new Order();
        orderBefore.setComplexity(5);

        // Set Date Format
        orderBefore.setEndDate(new GregorianCalendar(2021, 2, 20));
        orderBefore.setPrice(200);
        orderBefore.setStartDate(new GregorianCalendar(2021, 2, 18));
        orderBefore.setVehicle(new Vehicle());

        List<Worker> workerListBefore = new ArrayList<Worker>();

        workerListBefore.add(mainWorker);

        orderBefore.setWorkers(workerListBefore);

        // Create a list of Spare parts
        List<SparePart> sparePartsBefore = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            sparePartsBefore.add(new SparePart());
        }
        orderBefore.setSpareParts(sparePartsBefore);

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(orderNext);
        orders.add(orderBefore);

        schedule.setOrders(orders);
    }

    @Test
    public void testSortByComplexity() {
        schedule.sortByComplexity();

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (Order o : schedule.getOrders()) {
            stringJoiner.add(o.getComplexity() + "");
        }

        assertEquals("[1,5,6]", stringJoiner.toString());
    }

    @Test
    public void testSortByWorkers() {
        schedule.sortByWorkers();

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (Order o : schedule.getOrders()) {
            stringJoiner.add(o.getWorkers().size() + "");
        }


        assertEquals("[1,2,3]", stringJoiner.toString());
    }

    @Test
    public void testSortByPrice() {
        schedule.sortByPrice();

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (Order o : schedule.getOrders()) {
            stringJoiner.add(o.getPrice() + "");
        }


        assertEquals("[100,200,200]", stringJoiner.toString());
    }

    @Test
    public void testSortByStartDate() {
        schedule.sortByStartDate();

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (Order o : schedule.getOrders()) {
            stringJoiner.add(o.getStartDate().toInstant() + "");
        }


        assertEquals("[2021-03-17T22:00:00Z,2021-06-04T21:00:00Z,2021-11-09T22:00:00Z]", stringJoiner.toString());
    }

    @Test
    public void testSortByEndDate() {
        schedule.sortByEndDate();

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (Order o : schedule.getOrders()) {
            stringJoiner.add(o.getEndDate().toInstant() + "");
        }


        assertEquals("[2021-03-19T22:00:00Z,2021-06-09T21:00:00Z,2021-11-19T22:00:00Z]", stringJoiner.toString());
    }
}
