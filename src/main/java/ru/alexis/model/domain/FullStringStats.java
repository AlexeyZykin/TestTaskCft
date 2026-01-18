package ru.alexis.model.domain;

import ru.alexis.model.domain.api.IFullStringStats;

import java.util.List;

public class FullStringStats implements IFullStringStats {

    private final int count;

    private final int maxLength;

    private final int minLength;

    public FullStringStats(List<String> values) {
        this.count = values.size();

        this.maxLength = values.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        this.minLength = values.stream()
                .mapToInt(String::length)
                .min()
                .orElse(0);
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public int getMinLength() {
        return minLength;
    }

    @Override
    public int getElementCount() {
        return count;
    }

    @Override
    public String getDataTypeName() {
        return String.class.getSimpleName();
    }

    @Override
    public String toString() {
        return "String Stats {" +
                "count=" + count +
                ", maxLength=" + maxLength +
                ", minLength=" + minLength +
                '}';
    }
}
