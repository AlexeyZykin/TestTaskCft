package ru.alexis.model.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.alexis.model.domain.api.IFullNumberStats;

import java.util.List;

class FullFloatStatsTest {

    IFullNumberStats<Float> fullFloatStats;

    @BeforeEach
    void setUp() {
        List<Float> values = List.of(-10.5f, 5f, 20.5f);
        fullFloatStats = new FullFloatStats(values);
    }

    @Test
    void getMin() {
        var result = fullFloatStats.getMin();

        Assertions.assertEquals(-10.5f, result);
    }

    @Test
    void getMax() {
        var result = fullFloatStats.getMax();

        Assertions.assertEquals(20.5f, result);
    }

    @Test
    void getSum() {
        var result = fullFloatStats.getSum();

        Assertions.assertEquals(15f, result);
    }

    @Test
    void getAverage() {
        var result = fullFloatStats.getAverage();

        Assertions.assertEquals(5f, result);
    }

    @Test
    void getElementCount() {
        var result = fullFloatStats.getElementCount();

        Assertions.assertEquals(3, result);
    }

    @Test
    void getDataTypeName() {
        var result = fullFloatStats.getDataTypeName();

        Assertions.assertEquals("Float", result);
    }
}