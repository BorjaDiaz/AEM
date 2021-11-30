package com.pizza.agents.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class News {
    private List<String> pathList = new ArrayList<>();

    private final Logger log = LoggerFactory.getLogger(News.class);

    @Inject
    private String route;

    @SlingObject
    private ResourceResolver resourceResolver;

    @PostConstruct
    protected void init() {
        try {
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            if (pageManager != null){
                Page goalPage = pageManager.getContainingPage(resourceResolver.getResource(route));
                if(goalPage !=null) {
                    Iterator<Page> iterationPoint = goalPage.listChildren();
                    while(iterationPoint.hasNext()){
                        Page element = iterationPoint.next();
                        pathList.add(element.getPath());
                    }
                }
            }
        }
        catch (Exception e){
            log.info("ERROR: {}", e.getMessage());
        }
    }

    public List<String> getPathList() {
        return pathList;
    }
}
