package ru.alexis.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.alexis.exception.InvalidArgumentException;
import ru.alexis.model.StatisticsType;
import ru.alexis.model.cli.CommandLineArgs;
import ru.alexis.model.cli.Option;
import ru.alexis.util.CliUtils;
import ru.alexis.validator.InputArgumentsValidator;

import java.util.ArrayList;
import java.util.Optional;

public class CommandLineParser {

    private static final Logger log = LoggerFactory.getLogger(CommandLineParser.class);

    private static final String EMPTY_ARG_LIST_MESSAGE = "No command line arguments given";

    private static final String NO_OPTION_ARGS_MESSAGE_FORMAT = "No argument given for %s option";

    private static final String DUPLICATE_STATS_OPTION_MESSAGE = "Statistics type already set";

    private static final String NO_INPUT_FILES_MESSAGE = "No input files found";

    private final InputArgumentsValidator inputArgumentsValidator;

    public CommandLineParser(InputArgumentsValidator inputArgumentsValidator) {
        this.inputArgumentsValidator = inputArgumentsValidator;
    }

    public CommandLineArgs parse(String[] args) {
        if (args.length == 0) {
            throw new InvalidArgumentException(EMPTY_ARG_LIST_MESSAGE);
        }

        log.info("Input arguments {}", (Object) args);

        var files = new ArrayList<String>();
        var outputPath = "";
        var prefix = "";
        var appendMode = false;
        var statsMode = StatisticsType.NONE;

        for (int i = 0; i < args.length; i++) {
            var option = Optional.ofNullable(Option.fromString(args[i]));
            if (option.isEmpty()) {
                if (inputArgumentsValidator.validateInputFile(args[i])) {
                    files.add(args[i]);
                }
                continue;
            }

            switch (option.get()) {
                case Option.OUTPUT_PATH -> {
                    if (i + 1 >= args.length) {
                        var msg = String.format(NO_OPTION_ARGS_MESSAGE_FORMAT, args[i]);
                        log.info(msg);
                        break;
                    }
                    if (CliUtils.isOption(args[i + 1])) {
                        var msg = String.format(NO_OPTION_ARGS_MESSAGE_FORMAT, args[i]);
                        log.info(msg);
                        break;
                    }
                    if (inputArgumentsValidator.validateOutputPath(args[i + 1])) {
                        outputPath = args[i + 1];
                        i++;
                    }
                }

                case Option.PREFIX -> {
                    if (i + 1 >= args.length) {
                        var msg = String.format(NO_OPTION_ARGS_MESSAGE_FORMAT, args[i]);
                        log.info(msg);
                        break;
                    }
                    if (CliUtils.isOption(args[i + 1])) {
                        var msg = String.format(NO_OPTION_ARGS_MESSAGE_FORMAT, args[i]);
                        log.info(msg);
                        break;
                    }
                    prefix = args[i + 1];
                    i++;
                }

                case Option.APPEND_MODE -> appendMode = true;

                case Option.SHORT_STATS -> {
                    if (!statsMode.equals(StatisticsType.NONE)) {
                        log.info(DUPLICATE_STATS_OPTION_MESSAGE);
                        break;
                    }
                    statsMode = StatisticsType.SHORT;
                }

                case Option.FULL_STATS -> {
                    if (!statsMode.equals(StatisticsType.NONE)) {
                        log.info(DUPLICATE_STATS_OPTION_MESSAGE);
                        break;
                    }
                    statsMode = StatisticsType.FULL;
                }
            }
        }

        if (files.isEmpty()) {
            throw new InvalidArgumentException(NO_INPUT_FILES_MESSAGE);
        }

        return new CommandLineArgs(
                files,
                outputPath,
                prefix,
                appendMode,
                statsMode
        );
    }

}
