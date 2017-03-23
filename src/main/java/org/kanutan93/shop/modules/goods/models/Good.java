package org.kanutan93.shop.modules.goods.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Good {
    private String name;
    private String description;
    private int price;
    private String imageLink;

    @JsonCreator
    public Good(Map<String, Object> props){
        this.name = (String) props.get("name");
        this.description = (String) props.get("description");
        this.price = (Integer) props.get("price");
        this.imageLink = (String) props.get("imageLink");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getImageLink() {
        return imageLink;
    }
}
