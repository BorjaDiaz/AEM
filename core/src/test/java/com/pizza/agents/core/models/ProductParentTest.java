package com.pizza.agents.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(AemContextExtension.class)
class ProductParentTest {

    AemContext aemContext = new AemContext();
    ProductParent productParent;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(ProductParent.class);
        aemContext.load().json("/com/pizza/agents/core/models/ProductParent.json", "/components");
    }

    @Test
    void setPath() {
        aemContext.currentResource("/components/parent");
        productParent = aemContext.request().adaptTo(ProductParent.class);

        assertNotNull(productParent);
    }

    @Test
    void setTitle() {
    }

    @Test
    void setAsset() {
    }

    @Test
    void getPath() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void getAsset() {
    }
}