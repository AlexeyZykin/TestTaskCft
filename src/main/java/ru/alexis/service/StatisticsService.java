package ru.alexis.service;

import ru.alexis.model.domain.FilteringResult;
import ru.alexis.model.domain.FullFloatStats;
import ru.alexis.model.domain.FullIntegerStats;
import ru.alexis.model.domain.FullStringStats;
import ru.alexis.model.domain.ShortStats;
import ru.alexis.model.domain.api.IFullNumberStats;
import ru.alexis.model.domain.api.IFullStringStats;
import ru.alexis.model.domain.api.IStats;
import ru.alexis.printer.IStatsPrinter;

import java.util.List;

public class StatisticsService {

    private final IStatsPrinter shortStatsPrinter;
    private final IStatsPrinter fullStatsPrinter;

    public StatisticsService(IStatsPrinter shortStatsPrinter, IStatsPrinter fullStatsPrinter) {
        this.shortStatsPrinter = shortStatsPrinter;
        this.fullStatsPrinter = fullStatsPrinter;
    }

    public void collectShortStats(FilteringResult filteringResult) {
        IStats integerStats = new ShortStats<>(filteringResult.integers(), Integer.class);
        IStats floatStats = new ShortStats<>(filteringResult.floats(), Float.class);
        IStats stringStats = new ShortStats<>(filteringResult.strings(), String.class);

        List<IStats> statsList = List.of(integerStats, floatStats, stringStats);

        shortStatsPrinter.handle(statsList);
    }

    public void collectFullStats(FilteringResult filteringResult) {
        IFullNumberStats<Integer> integerStats = new FullIntegerStats(filteringResult.integers());
        IFullNumberStats<Float> floatStats = new FullFloatStats(filteringResult.floats());
        IFullStringStats stringStats = new FullStringStats(filteringResult.strings());

        List<IStats> statsList = List.of(integerStats, floatStats, stringStats);

        fullStatsPrinter.handle(statsList);
    }
}
