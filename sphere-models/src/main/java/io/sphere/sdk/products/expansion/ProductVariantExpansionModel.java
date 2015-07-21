package io.sphere.sdk.products.expansion;

import io.sphere.sdk.expansion.ExpansionModel;

public class ProductVariantExpansionModel<T> extends ExpansionModel<T> {
    ProductVariantExpansionModel(final String parentPath, final String path) {
        super(parentPath, path);
    }

    public PriceExpansionModel<T> prices() {
        return prices("*");
    }

    public PriceExpansionModel<T> prices(final int index) {
        return prices("" + index);
    }

    public ProductAttributeExpansionModel<T> attributes() {
        return new ProductAttributeExpansionModel<>(pathExpression(), "attributes[*]");
    }

    private PriceExpansionModel<T> prices(final String index) {
        return new PriceExpansionModel<>(pathExpression(), "prices[" + index + "]");
    }
}

