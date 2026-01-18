package ru.alexis.service;

import ru.alexis.model.domain.FilteringResult;

import java.util.ArrayList;
import java.util.List;

public class DataFilteringService {

    public DataFilteringService() {
    }

    public FilteringResult handleLines(List<String> lines) {
        var floats = new ArrayList<Float>();
        var integers = new ArrayList<Integer>();
        var strings = new ArrayList<String>();

        lines.forEach(line -> {
            if (line == null || line.trim().isEmpty()) {
                return;
            }
            var cleanLine = line.trim();

            if (isInteger(cleanLine)) {
                integers.add(Integer.parseInt(cleanLine));
            } else if (isFloat(cleanLine)) {
                floats.add(Float.parseFloat(cleanLine));
            } else {
                strings.add(cleanLine);
            }
        });

        return new FilteringResult(integers, strings, floats);
    }

    private boolean isInteger(String str) {
        try {
            if (str == null) {
                return false;
            }
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFloat(String str) {
        try {
            if (str == null) {
                return false;
            }

            if (!str.contains(".") && !str.contains("e") && !str.contains("E")) {
                return false;
            }

            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
