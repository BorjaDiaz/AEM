package com.pizza.agents.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.Objects;


@Component(service = Servlet.class)
@SlingServletPaths(
        value = "/bin/servlet/contact"
)

public class ContactServlet extends SlingAllMethodsServlet {

    private final Logger log = LoggerFactory.getLogger(ContactServlet.class);

    @Override
    protected void doGet( SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException {
        res.getWriter().println("test");
    }

    @Override
    protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse res) throws IOException {

        String path = Objects.requireNonNull(req.getRequestParameter("path")).getString();
        String gestor = Objects.requireNonNull(req.getRequestParameter("gestor")).getString();

        String client = Objects.requireNonNull(req.getRequestParameter("contact_email")).getString();
        String subject = Objects.requireNonNull(req.getRequestParameter("contact_subject")).getString();
        String body = Objects.requireNonNull(req.getRequestParameter("contact_message")).getString();


        Boolean emailCheck =  Email.sendEmail(gestor ,client, subject, body);

        if (Boolean.TRUE.equals(emailCheck)){
            res.sendRedirect(path + "?emailSend=success");
        }
        else {
            log.info("NO success in the email sending process");
            res.sendRedirect(path + "?emailSend=error");
        }
    }
}
