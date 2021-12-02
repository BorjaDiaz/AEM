package com.pizza.agents.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

//@Model(adaptables = Resource.class)
public class ProductsInfo {
    private String imageRoute;
    private String title;
    private String description;
    private String orderText;
    private String tamanio1;
    private String price1;
    private String tamanio2;
    private String price2;

    public String getImageRoute() {
        return imageRoute;
    }

    public void setImageRoute(String imageRoute) {
        this.imageRoute = imageRoute;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderText() {
        return orderText;
    }

    public void setOrderText(String orderText) {
        this.orderText = orderText;
    }

    public String getTamanio1() {
        return tamanio1;
    }

    public void setTamanio1(String tamanio1) {
        this.tamanio1 = tamanio1;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getTamanio2() {
        return tamanio2;
    }

    public void setTamanio2(String tamanio2) {
        this.tamanio2 = tamanio2;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }
}