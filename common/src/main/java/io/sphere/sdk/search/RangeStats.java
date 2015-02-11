package io.sphere.sdk.search;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.sphere.sdk.models.Base;

import java.util.Optional;

public class RangeStats<T> extends Base {
    private final Optional<T> lowerEndpoint;
    private final Optional<T> upperEndpoint;
    private final long count;
    private final T total;
    private final T min;
    private final T max;
    private final T mean;

    @JsonIgnore
    private RangeStats(final Optional<T> lowerEndpoint, final Optional<T> upperEndpoint, final long count,
                       final long totalCount, final T total, final T min, final T max, final T mean) {
        this.lowerEndpoint = lowerEndpoint;
        this.upperEndpoint = upperEndpoint;
        this.count = count;
        this.total = total;
        this.min = min;
        this.max = max;
        this.mean = mean;
    }

    @JsonCreator
    RangeStats(final T from, final T to, final String fromStr, final String toStr, final long count,
                       final long totalCount, final T total, final T min, final T max, final T mean) {
        this(parseEndpoint(from, fromStr), parseEndpoint(to, toStr), count, totalCount, total, min, max, mean);
    }

    /**
     * Lower endpoint of the range.
     * @return the lower endpoint, or absent if no lower bound defined.
     */
    public Optional<T> getLowerEndpoint() {
        return lowerEndpoint;
    }

    /**
     * Upper endpoint of the range.
     * @return the upper endpoint, or absent if no upper bound defined.
     */
    public Optional<T> getUpperEndpoint() {
        return upperEndpoint;
    }

    /**
     * Number of results that fall into this range.
     * @return the amount of results in the range.
     */
    public long getCount() {
        return count;
    }

    /**
     * Sum of the values contained within the range.
     * @return the sum of the values.
     */
    public T getSum() {
        return total;
    }

    /**
     * Minimum value contained within the range.
     * @return the minimum value.
     */
    public T getMin() {
        return min;
    }

    /**
     * Maximum value contained within the range.
     * @return the maximum value.
     */
    public T getMax() {
        return max;
    }

    /**
     * Arithmetic mean of the values contained within the range.
     * @return the mean of the values.
     */
    public T getMean() {
        return mean;
    }

    @JsonIgnore
    public static <T> RangeStats<T> of(final Optional<T> from, final Optional<T> to, final long count,
                                       final T sum, final T min, final T max, final T mean) {
        return new RangeStats<>(from, to, count, count, sum, min, max, mean);
    }

    @JsonIgnore
    private static <T> Optional<T> parseEndpoint(final T from, final String fromStr) {
        return fromStr.isEmpty() ? Optional.empty() : Optional.of(from);
    }
}
