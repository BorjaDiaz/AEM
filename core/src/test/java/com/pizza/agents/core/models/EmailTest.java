package com.pizza.agents.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class EmailTest {

    AemContext aemContext = new AemContext();
    Email email;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(Link.class);
        aemContext.load().json("/com/pizza/agents/core/models/EmailTest.json", "/component");
    }

    @Test
    void sendEmail() {

        aemContext.currentResource("/component/email");
        email = aemContext.request().adaptTo(Email.class);}
}