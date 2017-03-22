package org.kanutan93.shop.modules.users.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kanutan93.shop.modules.orders.models.Order;

import java.util.List;
import java.util.Map;

public class User {
    @JsonProperty("_id")
    String _id;
    @JsonProperty("name")
    String name;
    @JsonProperty("email")
    String email;
    @JsonProperty("orders")
    List<Order> orders;


    //TODO МБ убрать аннотации @JsonProperty
    @JsonCreator
    public User(Map<String, Object> props){
        this._id = (String) props.get("_id");
        this.name = (String) props.get("name");
        this.email= (String) props.get("email");
        this.orders= (List<Order>) props.get("orders");
    }

}
