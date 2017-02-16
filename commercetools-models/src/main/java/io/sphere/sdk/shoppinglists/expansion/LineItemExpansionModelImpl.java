package io.sphere.sdk.shoppinglists.expansion;

import io.sphere.sdk.expansion.ExpansionModelImpl;
import io.sphere.sdk.expansion.ExpansionPathContainer;
import io.sphere.sdk.products.expansion.ProductVariantExpansionModel;
import io.sphere.sdk.producttypes.expansion.ProductTypeExpansionModel;

import java.util.List;

final class LineItemExpansionModelImpl<T> extends ExpansionModelImpl<T> implements LineItemExpansionModel<T> {
    LineItemExpansionModelImpl(final List<String> parentPath, final String path) {
        super(parentPath, path);
    }

    @Override
    public ProductVariantExpansionModel<T> variant() {
        return ProductVariantExpansionModel.of(buildPathExpression(), "variant");
    }

    @Override
    public ProductTypeExpansionModel<T> productType() {
        return ProductTypeExpansionModel.of(buildPathExpression(), "productType");
    }

    @Override
    public ExpansionPathContainer<T> productSlug() {
        return new ExpansionModelImpl<T>(buildPathExpression(), "productSlug");
    }
}
