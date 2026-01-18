package ru.alexis.mapper;

import ru.alexis.model.StatisticsType;
import ru.alexis.model.cli.CommandLineArgs;
import ru.alexis.model.domain.ProcessingOptions;

public class OptionsMapper {

    public ProcessingOptions cliArgsToProcessingOptions(CommandLineArgs args) {
        return new ProcessingOptions(
                args.outputPath() != null ? args.outputPath() : "",
                args.prefix() != null ? args.prefix() : "",
                args.appendMode(),
                args.statisticsType() != null ? args.statisticsType() : StatisticsType.NONE
        );
    }

}
