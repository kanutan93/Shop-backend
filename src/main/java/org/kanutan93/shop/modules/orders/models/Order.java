package org.kanutan93.shop.modules.orders.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.kanutan93.shop.modules.goods.models.Good;

import java.util.List;
import java.util.Map;

public class Order {
    private String email;
    private String name;
    private String lastname;
    private List<ShoppingCart> shoppingCart;
    private String address;

    @JsonCreator
    public Order(Map<String, Object> props){
        this.name = (String) props.get("name");
        this.email = (String) props.get("email");
        this.lastname = (String) props.get("lastname");
        this.shoppingCart = (List<ShoppingCart>) props.get("shoppingCart");
        this.address = (String) props.get("address");
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public String getAddress() {
        return address;
    }
}
