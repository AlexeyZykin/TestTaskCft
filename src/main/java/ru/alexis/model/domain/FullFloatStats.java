package ru.alexis.model.domain;

import ru.alexis.model.domain.api.IFullNumberStats;

import java.util.List;

public class FullFloatStats implements IFullNumberStats<Float> {

    private final Integer count;

    private final Float max;

    private final Float min;

    private final Float sum;

    private final Double average;

    public FullFloatStats(List<Float> values) {
        count = values.size();

        this.max = values.stream()
                .max(Comparable::compareTo)
                .orElse(0f);

        this.min = values.stream()
                .min(Comparable::compareTo)
                .orElse(0f);

        this.sum = values.stream()
                .reduce(0.0f, Float::sum);

        this.average = count == 0 ? 0.0 : (double) sum / count;
    }

    @Override
    public Float getMin() {
        return min;
    }

    @Override
    public Float getMax() {
        return max;
    }

    @Override
    public Float getSum() {
        return sum;
    }

    @Override
    public Double getAverage() {
        return average;
    }

    @Override
    public int getElementCount() {
        return count;
    }

    @Override
    public String getDataTypeName() {
        return Float.class.getSimpleName();
    }

    @Override
    public String toString() {
        return "Float Stats {" +
                "count=" + count +
                ", max=" + max +
                ", min=" + min +
                ", sum=" + sum +
                ", average=" + average +
                '}';
    }
}
