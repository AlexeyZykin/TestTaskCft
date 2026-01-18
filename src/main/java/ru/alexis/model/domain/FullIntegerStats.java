package ru.alexis.model.domain;

import ru.alexis.model.domain.api.IFullNumberStats;

import java.util.List;

public class FullIntegerStats implements IFullNumberStats<Integer> {

    private final Integer count;

    private final Integer max;

    private final Integer min;

    private final Integer sum;

    private final Double average;

    public FullIntegerStats(List<Integer> values) {
        count = values.size();

        this.max = values.stream()
                .max(Comparable::compareTo)
                .orElse(null);

        this.min = values.stream()
                .min(Comparable::compareTo)
                .orElse(null);

        this.sum = values.stream()
                .reduce(0, Integer::sum);

        this.average = (double) (sum / count);
    }

    @Override
    public Integer getMin() {
        return min;
    }

    @Override
    public Integer getMax() {
        return max;
    }

    @Override
    public Integer getSum() {
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
        return Integer.class.getSimpleName();
    }

    @Override
    public String toString() {
        return "Integer Stats {" +
                "count=" + count +
                ", max=" + max +
                ", min=" + min +
                ", sum=" + sum +
                ", average=" + average +
                '}';
    }
}
