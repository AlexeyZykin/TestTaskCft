package ru.alexis.model.domain;

import java.util.List;

public record FilteringResult(
        List<Integer> integers,
        List<String> strings,
        List<Float> floats
) {
}
