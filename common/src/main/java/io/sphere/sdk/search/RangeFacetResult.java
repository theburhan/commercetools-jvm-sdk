package io.sphere.sdk.search;

import io.sphere.sdk.models.Base;

import java.util.List;

public class RangeFacetResult<T> extends Base implements FacetResult {
    private final List<RangeStats<T>> ranges;

    private RangeFacetResult(final List<RangeStats<T>> ranges) {
        this.ranges = ranges;
    }

    public List<RangeStats<T>> getRanges() {
        return ranges;
    }

    public static <T> RangeFacetResult<T> of(final List<RangeStats<T>> ranges) {
        return new RangeFacetResult<>(ranges);
    }
}
