package ru.alexis.model.domain;

import ru.alexis.model.StatisticsType;

public record ProcessingOptions(
        String outputPath,

        String prefix,

        boolean appendMode,

        StatisticsType statisticsType
) {
}
