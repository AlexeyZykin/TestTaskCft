package ru.alexis.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.alexis.exception.InvalidArgumentException;
import ru.alexis.mapper.OptionsMapper;
import ru.alexis.parser.CommandLineParser;
import ru.alexis.service.FileProcessingService;

public class DataFilterApp {

    private static final Logger log = LoggerFactory.getLogger(DataFilterApp.class);
    private final CommandLineParser commandLineParser;
    private final OptionsMapper optionsMapper;
    private final FileProcessingService fileProcessingService;

    public DataFilterApp(
            CommandLineParser commandLineParser,
            OptionsMapper optionsMapper,
            FileProcessingService fileProcessingService
    ) {
        this.commandLineParser = commandLineParser;
        this.optionsMapper = optionsMapper;
        this.fileProcessingService = fileProcessingService;
    }

    public void run(String[] args) {
        try {
            var commandLineArgs = commandLineParser.parse(args);

            var processingOptions = optionsMapper.cliArgsToProcessingOptions(commandLineArgs);

            fileProcessingService.process(commandLineArgs.files(), processingOptions);
        } catch (InvalidArgumentException e) {
            log.error(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
