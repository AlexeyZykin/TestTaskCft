package ru.alexis.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.alexis.exception.FileWriteFailedException;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DataFileWriter {

    private static final Logger log = LoggerFactory.getLogger(DataFileWriter.class);

    public void write(
            List<?> items,
            String fileName,
            String prefix,
            String outputPath,
            boolean appendMode
    ) {
        Path dirPath = Path.of(outputPath);
        Path path = dirPath.resolve(prefix + fileName);

        try (BufferedWriter bw = Files.newBufferedWriter(
                path,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                appendMode ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING
        )) {
            items.forEach(item -> {
                try {
                    bw.write(item.toString());
                    bw.newLine();
                } catch (IOException e) {
                    log.error("Failed to write line {}: {}", item, e.getMessage());
                }
            });
        } catch (IOException e) {
            log.error(e.getMessage());
            var msg = String.format("Error writing to file '%s'", fileName);
            throw new FileWriteFailedException(msg);
        }
    }

}
