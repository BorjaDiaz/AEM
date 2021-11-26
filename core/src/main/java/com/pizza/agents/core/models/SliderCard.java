package com.pizza.agents.core.models;

import static org.apache.sling.api.resource.ResourceResolver.PROPERTY_RESOURCE_TYPE;

import javax.annotation.PostConstruct;
import javax.inject.Inject;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
//import java.util.Optional;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class SliderCard {

    @ValueMapValue(name=PROPERTY_RESOURCE_TYPE,  injectionStrategy=InjectionStrategy.OPTIONAL)
    @Default(values="No resourceType")
    protected String resourceType;

    @SlingObject
    private Resource currentResource;
    @SlingObject
    private ResourceResolver resourceResolver;

    private final Logger loggerCard= LoggerFactory.getLogger(SliderCard.class);

    private Page page;



    private ArrayList<SliderCardInfo> componentsInfo=new ArrayList<>();
    private SliderCardInfo componentInfo=new SliderCardInfo();


    @Inject @Optional
    private String productsRoute;


    @PostConstruct
    protected void init() {

        PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
        try {
        for (Resource rsc : resourceResolver.getResource(productsRoute).getChildren())    {
            if(!rsc.getName().equals("jcr:content")){
                StringBuilder str = new StringBuilder();
                page = pageManager.getContainingPage(rsc);

                    componentInfo=new SliderCardInfo();

                    str.append("OBTAINING DATA FROM: ").append(rsc.getName()).append(" en ").append(rsc.getPath());
                    loggerCard.info(str.toString());
                    str.setLength(0);
                    componentInfo.setTitle(page.getContentResource("root").getChild("title").getPath());
                    componentInfo.setImageRoute(page.getContentResource("root").getChild("image").getPath());
                    componentInfo.setDescription(page.getContentResource("root").getChild("text").getPath());
                    componentInfo.setOrderText(page.getContentResource("root").getChild("text_726754299").getPath());
                    componentInfo.setTamanio1(page.getContentResource("root").getChild("text_1280387070").getPath());
                    componentInfo.setPrice1(page.getContentResource("root").getChild("text_536436341").getPath());
                    componentInfo.setTamanio2(page.getContentResource("root").getChild("text_1310728108").getPath());
                    componentInfo.setPrice2(page.getContentResource("root").getChild("text_1423635834").getPath());


                    componentsInfo.add(componentInfo);



            }


        }
        }catch(Exception e){


        }
    }



    public ArrayList<SliderCardInfo> getComponentsInfo() {
        return componentsInfo;
    }
}