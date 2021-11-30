package com.pizza.agents.core.models;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Iterator;


@Model(adaptables = {
        SlingHttpServletRequest.class, Resource.class
})
public class LanguageButtomModel{

    private static final Logger LOG = LoggerFactory.getLogger(LanguageButtomModel.class);

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
            LOG.info("navigationRoot: " + navigationRoot);
            if(navigationRoot != null) {
                childIterator = navigationRoot.listChildren();
                while(childIterator.hasNext()){
                    language = childIterator.next().getName();
                    LOG.info("language: " + language);
                    path = page.getPath().replace("es",language);
                    LOG.info("Path: " + path);
                }
            }
            /*if(currentPagePath.contains("/en/")){
               path = currentPagePath.replace("/en/","/es/");
               lang = "EN";
               langChild = "ES";
            }
            if(currentPagePath.contains("/es/")){
               path = currentPagePath.replace("/es/","/en/");
               lang = "ES";
               langChild = "EN";
            }*/
        }catch (Exception ex){
            LOG.error(ex.toString());
        }

    }

    public String getPath(){
        return path;
    }



}
