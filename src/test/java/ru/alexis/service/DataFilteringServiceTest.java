package ru.alexis.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataFilteringServiceTest {

    DataFilteringService dataFilteringService;

    @BeforeEach
    void setUp() {
        dataFilteringService = new DataFilteringService();
    }

    @Test
    void filterLines() {
        var lines = List.of("Привет", "1500", "12.5");

        var result = dataFilteringService.handleLines(lines);

        assertEquals(1, result.integers().size());
        assertEquals(1, result.floats().size());
        assertEquals(1, result.strings().size());

        assertEquals(1500, result.integers().getFirst());
        assertEquals(12.5f, result.floats().getFirst());
        assertEquals("Привет", result.strings().getFirst());
    }
}