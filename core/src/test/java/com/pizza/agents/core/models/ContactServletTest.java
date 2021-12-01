// package com.pizza.agents.core.models;

// import io.wcm.testing.mock.aem.junit5.AemContext;
// import io.wcm.testing.mock.aem.junit5.AemContextExtension;
// import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
// import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;

// import java.io.IOException;

// import com.pizza.agents.core.models.Email;
// import static org.junit.jupiter.api.Assertions.*;

// @ExtendWith(AemContextExtension.class)
// class ContactServletTest {

//     AemContext aemContext = new AemContext();

//     ContactServlet unitTest = new ContactServlet();

//     @BeforeEach
//     void setUp() throws IOException{
//         aemContext.build().resource("/content/pizza005/test", "jcr:title", "test page");
//         aemContext.currentResource("/content/pizza005/test");
//     }

//     @Test
//     void doPostTest() throws IOException {

//         MockSlingHttpServletRequest req = aemContext.request();
//         MockSlingHttpServletResponse res = aemContext.response();

//         req.addRequestParameter("path", "http://localhost:4502/content/pizza005/language-masters/en/index/contact.html");
//         req.addRequestParameter("gestor", "pizzabay.005@gmail.com");
//         req.addRequestParameter("contact_email", "j.suarez@codebay-innovation.com");
//         req.addRequestParameter("contact_subject", "unitTest");
//         req.addRequestParameter("contact_message", "unitTest");

//         unitTest.doPost(req, res);
//     }
// }