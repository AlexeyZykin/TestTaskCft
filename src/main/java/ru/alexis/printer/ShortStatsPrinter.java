package ru.alexis.printer;

import ru.alexis.model.domain.api.IStats;

import java.util.List;

public class ShortStatsPrinter implements IStatsPrinter {

    @Override
    public void handle(List<? extends IStats> statsList) {
        System.out.println("SHORT STATISTICS REPORT");
        statsList.forEach(item -> System.out.println("\t" + item.toString()));
    }
}
