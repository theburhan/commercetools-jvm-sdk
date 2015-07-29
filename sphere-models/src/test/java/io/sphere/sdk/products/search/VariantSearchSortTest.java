package io.sphere.sdk.products.search;

import io.sphere.sdk.products.ProductProjection;
import io.sphere.sdk.search.StringSearchModel;
import org.junit.Test;

import static io.sphere.sdk.products.search.VariantSearchSortDirection.*;
import static org.assertj.core.api.Assertions.assertThat;

public class VariantSearchSortTest {

    @Test
    public void buildsAscendingSortExpression() throws Exception {
        assertThat(attributeModel().sort(ASC).toSphereSort()).isEqualTo("variants.attributes.size asc");
    }

    @Test
    public void buildsDescendingSortExpression() throws Exception {
        assertThat(attributeModel().sort(DESC).toSphereSort()).isEqualTo("variants.attributes.size desc");
    }

    @Test
    public void buildsAscendingSortExpressionWithAppendedParameter() throws Exception {
        assertThat(attributeModel().sort(ASC_MAX).toSphereSort()).isEqualTo("variants.attributes.size asc.max");
    }

    @Test
    public void buildsDescendingSortExpressionWithAppendedParameter() throws Exception {
        assertThat(attributeModel().sort(DESC_MIN).toSphereSort()).isEqualTo("variants.attributes.size desc.min");
    }

    private StringSearchModel<ProductProjection, VariantSearchSortDirection> attributeModel() {
        return searchModel().allVariants().attribute().ofText("size");
    }

    private ExperimentalProductProjectionSearchModel searchModel() {
        return ExperimentalProductProjectionSearchModel.of();
    }
}