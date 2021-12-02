package com.pizza.agents.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class LinkTest {

    AemContext aemContext = new AemContext();
    Link link;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(Link.class);
        aemContext.load().json("/com/pizza/agents/core/models/LinkTest.json", "/component");
    }

    @Test
    void atom() {
    }

    @Test
    void getText() {
        aemContext.currentResource("/component/link");
        link = aemContext.request().adaptTo(Link.class);
    }

    @Test
    void getLinkURL() {
        aemContext.currentResource("/component/link");
        link = aemContext.request().adaptTo(Link.class);
    }
}