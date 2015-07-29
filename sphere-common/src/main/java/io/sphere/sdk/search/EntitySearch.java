package io.sphere.sdk.search;

import javax.annotation.Nullable;
import java.util.List;

public interface EntitySearch<T> extends Search<T> {

    @Nullable
    SearchText text();

    List<FacetExpression<T>> facets();

    List<FilterExpression<T>> resultFilters();

    List<FilterExpression<T>> queryFilters();

    List<FilterExpression<T>> facetFilters();

    List<SearchSort<T>> sort();

    @Nullable
    Long limit();

    @Nullable
    Long offset();

    String endpoint();
}
