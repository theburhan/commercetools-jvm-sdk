package io.sphere.sdk.carts.queries;

import io.sphere.sdk.channels.Channel;
import io.sphere.sdk.products.queries.PriceCollectionQueryModel;
import io.sphere.sdk.products.queries.PriceQueryModel;
import io.sphere.sdk.products.queries.ProductVariantQueryModel;
import io.sphere.sdk.queries.*;

final class LineItemCollectionQueryModelImpl<T> extends QueryModelImpl<T> implements LineItemCollectionQueryModel<T> {
    public LineItemCollectionQueryModelImpl(final QueryModel<T> parent, final String pathSegment) {
        super(parent, pathSegment);
    }

    @Override
    public ReferenceOptionalQueryModel<T, Channel> distributionChannel() {
        return referenceOptionalModel("distributionChannel");
    }

    @Override
    public ReferenceOptionalQueryModel<T, Channel> supplyChannel() {
        return referenceOptionalModel("supplyChannel");
    }

    @Override
    public QueryPredicate<T> isEmpty() {
        return isEmptyCollectionQueryPredicate();
    }

    @Override
    public QueryPredicate<T> isNotEmpty() {
        return isNotEmptyCollectionQueryPredicate();
    }

    @Override
    public StringQueryModel<T> id() {
        return stringModel("id");
    }

    @Override
    public LongQuerySortingModel<T> quantity() {
        return longModel("quantity");
    }

    @Override
    public LocalizedStringQueryModel<T> name() {
        return localizedStringQuerySortingModel("name");
    }

    @Override
    public ProductVariantQueryModel<T> variant() {
        return new ProductVariantQueryModel<>(this, "variant");
    }

    @Override
    public PriceQueryModel<T> price() {
        return new PriceCollectionQueryModel<>(this, "price");
    }

    @Override
    public ItemStateCollectionQueryModel<T> state() {
        return new ItemStateCollectionQueryModelImpl<>(this, "state");
    }
}
