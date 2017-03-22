package org.kanutan93.shop.modules.goods.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Good {
    @JsonProperty("_id")
    String _id;
    @JsonProperty("name")
    String name;
    @JsonProperty("description")
    String description;
    @JsonProperty("price")
    int price;
    @JsonProperty("imageLink")
    String imageLink;

    //TODO МБ убрать аннотации @JsonProperty
    @JsonCreator
    public Good(Map<String, Object> props){
        this._id = (String) props.get("_id");
        this.name = (String) props.get("name");
        this.description = (String) props.get("description");
        this.price = (Integer) props.get("price");
        this.imageLink = (String) props.get("imageLink");
    }
}
