package ru.alexis;

import ru.alexis.app.DataFilterApp;
import ru.alexis.io.DataFileWriter;
import ru.alexis.io.InputFileReader;
import ru.alexis.mapper.OptionsMapper;
import ru.alexis.parser.CommandLineParser;
import ru.alexis.printer.FullStatsPrinter;
import ru.alexis.printer.IStatsPrinter;
import ru.alexis.printer.ShortStatsPrinter;
import ru.alexis.service.DataFilteringService;
import ru.alexis.service.FileProcessingService;
import ru.alexis.service.StatisticsService;
import ru.alexis.validator.InputArgumentsValidator;

public class Main {

    public static void main(String[] args) {
        var validator = new InputArgumentsValidator();
        var commandLineParser = new CommandLineParser(validator);
        var optionsMapper = new OptionsMapper();

        var inputFileReader = new InputFileReader();
        var dataFileWriter = new DataFileWriter();

        var dataFilteringService = new DataFilteringService();

        IStatsPrinter shortStatsPrinter = new ShortStatsPrinter();
        IStatsPrinter fullStatsPrinter = new FullStatsPrinter();
        var statisticsService = new StatisticsService(shortStatsPrinter, fullStatsPrinter);

        var fileProcessingService = new FileProcessingService(
                inputFileReader,
                dataFileWriter,
                dataFilteringService,
                statisticsService
        );

        var app = new DataFilterApp(
                commandLineParser,
                optionsMapper,
                fileProcessingService
        );
        app.run(args);
    }
}