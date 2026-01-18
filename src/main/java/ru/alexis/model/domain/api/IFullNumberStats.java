package ru.alexis.model.domain.api;

public interface IFullNumberStats<T extends Number & Comparable<T>> extends IStats {

    T getMin();

    T getMax();

    T getSum();

    Double getAverage();

}
