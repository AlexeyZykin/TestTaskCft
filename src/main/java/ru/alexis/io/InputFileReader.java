package ru.alexis.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputFileReader {

    private static final Logger log = LoggerFactory.getLogger(InputFileReader.class);

    public List<String> read(String filePath) {
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            return Collections.emptyList();
        }

        try (BufferedReader br = Files.newBufferedReader(path)) {
            List<String> result = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException e) {
            log.warn("Error reading file {}: {}", filePath, e.getMessage());
            return Collections.emptyList();
        }
    }

}
