package com.pizza.agents.core.models;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Model(adaptables = {
        SlingHttpServletRequest.class, Resource.class
})
public class LanguageButtomModel{

    private static final Logger LOG = LoggerFactory.getLogger(LanguageButtomModel.class);

    @SlingObject @Via("resource")
    private ResourceResolver resourceResolver;

    List<Page> paths = new ArrayList<Page>();

    @ScriptVariable(name="currentPage")
    Page page;

    @Inject @Via("resource")
    private Page navigationRoot;

    private Iterator<Page> childIterator;

    String path;

    String language;

    @PostConstruct
    protected void init() {
        LOG.info("==================  LanguageButtomModel ========================");
        try{

            LOG.info("Page: " + page.getPath());
            LOG.info("navigationRoot: " + navigationRoot.getPath());
            if(navigationRoot != null) {
                childIterator = navigationRoot.listChildren();
                while(childIterator.hasNext()){
                    language = childIterator.next().getName();
                    LOG.info("language: " + language);
                    LOG.info("Page Path: " + page.getPath());
                    if(!page.getPath().contains("/"+language+"/")){
                        path = page.getPath().replace("/"+page.getLanguage().toString()+"/","/"+language+"/");
                        LOG.info("path: " + path);
                        Resource resource = resourceResolver.getResource(path);
                        LOG.info("resource: " + resource);
                        if(resource != null){
                            paths.add(resource.adaptTo(Page.class));
                            LOG.info("Paths: " + paths);
                        }
                    }

                }
                for(int i = 0; i < paths.size(); i++){
                    LOG.info("Paths: " + paths.get(i).getTitle());
                }
            }
        }catch (Exception ex){
            LOG.error(ex.toString());
        }

    }


    public List<Page> getPaths(){
        return paths;
    }



}
