package com.softserve.maintenance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {
    Order order = new Order();

    @Test
    public void testExceptionWithoutAnyVehicles() {
        assertThrows(IllegalArgumentException.class, () -> {
            order.setVehicle(null);;
        });
    }

    @Test
    public void testExceptionWithNegativeComplexity() {
        assertThrows(IllegalArgumentException.class, () -> {
            order.setComplexity(-1);;
        });
    }

    @Test
    public void testExceptionWithoutSpareParts() {
        assertThrows(IllegalArgumentException.class, () -> {
            order.setSpareParts(new ArrayList<>());
        });
    }

    @Test
    public void testExceptionWithoutWorkers() {
        assertThrows(IllegalArgumentException.class, () -> {
            order.setWorkers(new ArrayList<>());
        });
    }

    @Test
    public void testExceptionStartDateGoesAfterEndDate() {

        order.setEndDate(new GregorianCalendar(2021, 2, 10));
        order.setStartDate(new GregorianCalendar(2021, 2, 20));
        assertThrows(IllegalArgumentException.class, () -> {
            order.checkDates();
        });
    }

    @Test
    public void testExceptionPriceBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            order.setPrice(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            order.setPrice(-1);
        });
    }
}
