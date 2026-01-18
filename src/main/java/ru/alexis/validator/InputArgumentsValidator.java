package ru.alexis.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputArgumentsValidator {

    private static final Logger logger = LoggerFactory.getLogger(InputArgumentsValidator.class);

    public InputArgumentsValidator() {
    }

    public boolean validateOutputPath(String outputPath) {
        try {
            Path path = Paths.get(outputPath).toAbsolutePath();
            return Files.exists(path) && Files.isDirectory(path);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return false;
        }
    }

    public boolean validateInputFile(String inputPath) {
        try {
            Path path = Paths.get(inputPath);
            return Files.exists(path) && Files.isRegularFile(path);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return false;
        }
    }

}
