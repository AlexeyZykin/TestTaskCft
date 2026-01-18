package ru.alexis.model.domain;

import ru.alexis.model.domain.api.IStats;

import java.util.List;

public class ShortStats<T> implements IStats {

    private final int count;
    private final String dataTypeName;

    public ShortStats(List<T> values, Class<T> dataType) {
        this.count = values.size();
        this.dataTypeName = dataType.getSimpleName();
    }

    @Override
    public int getElementCount() {
        return count;
    }

    @Override
    public String getDataTypeName() {
        return dataTypeName;
    }

    @Override
    public String toString() {
        return String.format("%s { count: %d }", dataTypeName, count);
    }
}
