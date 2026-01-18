package ru.alexis.model.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.alexis.model.domain.api.IFullNumberStats;
import ru.alexis.model.domain.api.IFullStringStats;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FullStringStatsTest {

    IFullStringStats fullStringStats;

    @BeforeEach
    void setUp() {
        List<String> values = List.of("Привет", "Hello World", "str3");
        fullStringStats = new FullStringStats(values);
    }


    @Test
    void getMaxLength() {
        var actual = fullStringStats.getMaxLength();

        Assertions.assertEquals(11, actual);
    }

    @Test
    void getMinLength() {
        var actual = fullStringStats.getMinLength();

        Assertions.assertEquals(4, actual);
    }

    @Test
    void getElementCount() {
        var actual = fullStringStats.getElementCount();

        Assertions.assertEquals(3, actual);
    }

    @Test
    void getDataTypeName() {
        var actual = fullStringStats.getDataTypeName();

        Assertions.assertEquals("String", actual);
    }
}