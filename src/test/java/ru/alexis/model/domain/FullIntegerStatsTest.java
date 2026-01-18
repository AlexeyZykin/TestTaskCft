package ru.alexis.model.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.alexis.model.domain.api.IFullNumberStats;

import java.util.List;

class FullIntegerStatsTest {

    IFullNumberStats<Integer> fullIntegerStats;

    @BeforeEach
    void setUp() {
        List<Integer> values = List.of(-10, 5, 20);
        fullIntegerStats = new FullIntegerStats(values);
    }

    @Test
    void getMin() {
        var actual = fullIntegerStats.getMin();

        Assertions.assertEquals(-10, actual);
    }

    @Test
    void getMax() {
        var actual = fullIntegerStats.getMax();

        Assertions.assertEquals(20, actual);
    }

    @Test
    void getSum() {
        var actual = fullIntegerStats.getSum();

        Assertions.assertEquals(15, actual);
    }

    @Test
    void getAverage() {
        var actual = fullIntegerStats.getAverage();

        Assertions.assertEquals(5.0, actual);
    }

    @Test
    void getElementCount() {
        var actual = fullIntegerStats.getElementCount();

        Assertions.assertEquals(3, actual);
    }

    @Test
    void getDataTypeName() {
        var actual = fullIntegerStats.getDataTypeName();

        Assertions.assertEquals("Integer", actual);
    }
}