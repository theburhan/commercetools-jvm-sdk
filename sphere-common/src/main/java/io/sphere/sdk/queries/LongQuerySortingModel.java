package io.sphere.sdk.queries;

import java.util.Optional;

public class LongQuerySortingModel<T> extends IntegerLikeQuerySortingModel<T, Long> {
    public LongQuerySortingModel(final Optional<? extends QueryModel<T>> parent, final String pathSegment) {
        super(parent, pathSegment);
    }

    @Override
    public QueryPredicate<T> is(final Long i) {
        return super.is(i);
    }

    @Override
    public QueryPredicate<T> isGreaterThan(final Long value) {
        return super.isGreaterThan(value);
    }

    @Override
    public QueryPredicate<T> isGreaterThanOrEqualTo(final Long value) {
        return super.isGreaterThanOrEqualTo(value);
    }

    @Override
    public QueryPredicate<T> isLessThan(final Long value) {
        return super.isLessThan(value);
    }

    @Override
    public QueryPredicate<T> isLessThanOrEqualTo(final Long value) {
        return super.isLessThanOrEqualTo(value);
    }

    @Override
    public QueryPredicate<T> isNot(final Long i) {
        return super.isNot(i);
    }

    @Override
    public QueryPredicate<T> isNotIn(final Long arg0, final Long... args) {
        return super.isNotIn(arg0, args);
    }

    @Override
    public QueryPredicate<T> isNotIn(final Iterable<Long> args) {
        return super.isNotIn(args);
    }

    @Override
    public QueryPredicate<T> isNotPresent() {
        return super.isNotPresent();
    }

    @SuppressWarnings("unchecked")
    @Override
    public QueryPredicate<T> isIn(final Long arg0, final Long... args) {
        return super.isIn(arg0, args);
    }

    @Override
    public QueryPredicate<T> isIn(final Iterable<Long> args) {
        return super.isIn(args);
    }

    @Override
    public QueryPredicate<T> isPresent() {
        return super.isPresent();
    }

    @Override
    public QuerySort<T> sort(final QuerySortDirection sortDirection) {
        return super.sort(sortDirection);
    }
}