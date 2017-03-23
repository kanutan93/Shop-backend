package org.kanutan93.shop.modules.users.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kanutan93.shop.modules.orders.models.Order;

import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private String email;
    private List<Order> orders;

    @JsonCreator
    public User(Map<String, Object> props){
        this.name = (String) props.get("name");
        this.email= (String) props.get("email");
        this.orders= (List<Order>) props.get("orders");
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
