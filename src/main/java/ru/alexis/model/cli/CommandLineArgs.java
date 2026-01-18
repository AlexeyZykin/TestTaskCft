package ru.alexis.model.cli;

import ru.alexis.model.StatisticsType;

import java.util.List;

public record CommandLineArgs(

        List<String> files,

        String outputPath,

        String prefix,

        boolean appendMode,

        StatisticsType statisticsType

) {
}
