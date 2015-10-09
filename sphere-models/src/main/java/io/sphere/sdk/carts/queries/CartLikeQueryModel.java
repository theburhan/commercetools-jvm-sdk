package io.sphere.sdk.carts.queries;

import io.sphere.sdk.customergroups.CustomerGroup;
import io.sphere.sdk.queries.*;

/**
 * Base class to create predicates for {@link io.sphere.sdk.carts.CartLike} resources.
 * @param <T> query context
 */
public abstract class CartLikeQueryModel<T> extends ResourceQueryModelImpl<T> {
    protected CartLikeQueryModel(QueryModel<T> parent, String pathSegment) {
        super(parent, pathSegment);
    }

    public StringQuerySortingModel<T> customerId() {
        return stringModel("customerId");
    }

    public StringQuerySortingModel<T> customerEmail() {
        return stringModel("customerEmail");
    }

    public MoneyQueryModel<T> totalPrice() {
        return moneyModel("totalPrice");
    }

    public TaxedPriceOptionalQueryModel<T> taxedPrice() {
        return new TaxedPriceOptionalQueryModelImpl<>(this, "taxedPrice");
    }

    public CountryQueryModel<T> country() {
        return countryQueryModel("country");
    }

    public ReferenceOptionalQueryModel<T, CustomerGroup> customerGroup() {
        return referenceOptionalModel("customerGroup");
    }

    public LineItemCollectionQueryModel<T> lineItems() {
        return new LineItemCollectionQueryModelImpl<>(this, "lineItems");
    }
}