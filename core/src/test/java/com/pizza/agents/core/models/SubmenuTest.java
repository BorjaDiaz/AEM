package com.pizza.agents.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class SubmenuTest {

    AemContext aemContext = new AemContext();
    Submenu submenu;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(Submenu.class);
        aemContext.load().json("/com/pizza/agents/core/models/SubmeuTest.json", "/component");
    }

    @Test
    void init() {
        aemContext.currentResource("/component/submenu");
        submenu = aemContext.request().adaptTo(Submenu.class);
    }

    @Test
    void getPathList() {
    }
}