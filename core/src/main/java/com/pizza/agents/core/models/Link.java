package com.pizza.agents.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.File;
import java.net.FileNameMap;
import java.net.URI;
import java.net.URLConnection;


@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Link {

    private final Logger log = LoggerFactory.getLogger(Link.class);

    @Inject
    private String text;

    @Inject
    private String linkURL;

    @PostConstruct
    public void atom(){

        try {
            URI uri = URI.create(linkURL);

            if (!uri.isAbsolute()){
                File file = new File(linkURL);
                FileNameMap fileNameMap = URLConnection.getFileNameMap();
                String mimeType = fileNameMap.getContentTypeFor(file.getName());

                log.info("linkURL {}", linkURL);
                log.info("mimeType {}", mimeType);

                if (mimeType == null){
                    linkURL = linkURL + ".html";
                }
            }}
        catch (Exception e){
            log.info("ERROR: {}", e.getMessage());
        }
    }

    public String getText() { return text; }

    public String getLinkURL() {
        return linkURL;
    }
}
