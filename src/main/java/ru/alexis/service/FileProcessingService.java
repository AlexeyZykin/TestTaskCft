package ru.alexis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.alexis.config.Config;
import ru.alexis.io.DataFileWriter;
import ru.alexis.io.InputFileReader;
import ru.alexis.model.StatisticsType;
import ru.alexis.model.domain.ProcessingOptions;

import java.util.ArrayList;
import java.util.List;

public class FileProcessingService {

    private static final Logger log = LoggerFactory.getLogger(FileProcessingService.class);
    private final InputFileReader inputFileReader;
    private final DataFileWriter dataFileWriter;
    private final DataFilteringService dataFilteringService;
    private final StatisticsService statisticsService;

    public FileProcessingService(
            InputFileReader inputFileReader,
            DataFileWriter dataFileWriter,
            DataFilteringService dataFilteringService,
            StatisticsService statisticsService
    ) {
        this.inputFileReader = inputFileReader;
        this.dataFileWriter = dataFileWriter;
        this.dataFilteringService = dataFilteringService;
        this.statisticsService = statisticsService;
    }

    public void process(List<String> files, ProcessingOptions options) {
        var allLines = new ArrayList<String>();

        files.forEach(file -> {
            var lines = inputFileReader.read(file);
            allLines.addAll(lines);

            log.info("Data from file {}: {}", file, lines);
        });

        var filteringResult = dataFilteringService.handleLines(allLines);

        if (!filteringResult.integers().isEmpty()) {
            dataFileWriter.write(
                    filteringResult.integers(),
                    Config.INTEGER_FILE_NAME,
                    options.prefix(),
                    options.outputPath(),
                    options.appendMode()
            );
        }
        if (!filteringResult.floats().isEmpty()) {
            dataFileWriter.write(
                    filteringResult.floats(),
                    Config.FLOAT_FILE_NAME,
                    options.prefix(),
                    options.outputPath(),
                    options.appendMode()
            );
        }
        if (!filteringResult.strings().isEmpty()) {
             dataFileWriter.write(
                    filteringResult.strings(),
                    Config.STRING_FILE_NAME,
                    options.prefix(),
                    options.outputPath(),
                    options.appendMode()
            );
        }

        if (options.statisticsType().equals(StatisticsType.SHORT)) {
            statisticsService.collectShortStats(filteringResult);
        } else if (options.statisticsType().equals(StatisticsType.FULL)) {
            statisticsService.collectFullStats(filteringResult);
        }
    }

}
