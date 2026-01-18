package ru.alexis.printer;

import ru.alexis.model.domain.api.IStats;

import java.util.List;

public interface IStatsPrinter {

    void handle(List<? extends IStats> stats);

}
