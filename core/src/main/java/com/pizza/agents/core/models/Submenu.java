package com.pizza.agents.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Submenu {

    private List<ProductParent> pathList = new ArrayList<>();

    private final Logger log = LoggerFactory.getLogger(Submenu.class);

    @Inject
    private String linkURL;

    @SlingObject
    private ResourceResolver resourceResolver;

    @PostConstruct
    protected void init() {
        try {
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

            if (pageManager != null){
                Page goalPage = pageManager.getContainingPage(resourceResolver.getResource(linkURL));

                Iterator<Page> iterationPoint = goalPage.listChildren();

                while(iterationPoint.hasNext()){

                    Page element = iterationPoint.next();

                    String icon = element.getProperties().get("linkAsset").toString();

                    ProductParent item = new ProductParent();

                    if (icon != null){
                        item.setAsset(icon);
                    }

                    item.setTitle(element.getTitle());

                    item.setPath(element.getPath());

                    pathList.add(item);

                } }}
        catch (Exception e){
            log.info("ERROR: {}", e.getMessage());
        }
    }

    public List<ProductParent> getPathList() {
        return pathList;
    }
}

