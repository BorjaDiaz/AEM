package com.pizza.agents.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class ProductsManager {

    private List<ProductParent> pathList = new ArrayList<>();

    private final Logger log = LoggerFactory.getLogger(ProductsManager.class);

    @Inject @Optional
    private String productsRoute;

    @SlingObject
    private Resource currentResource;

    @SlingObject
    private ResourceResolver resourceResolver;



    @PostConstruct
    protected void init() {
        try {
            PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

            if (pageManager != null){
                Page goalPage = pageManager.getContainingPage(pageManager.getContainingPage(currentResource).getPath());

                Iterator<Page> iterationPoint = goalPage.listChildren();

                while(iterationPoint.hasNext()){

                    Page element = iterationPoint.next();
                    ProductParent item = new ProductParent();
                    String icon;

                    if(element.getProperties().get("linkAsset")!=null) {
                        icon = element.getProperties().get("linkAsset").toString();
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
