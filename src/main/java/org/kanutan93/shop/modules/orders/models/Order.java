package org.kanutan93.shop.modules.orders.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kanutan93.shop.modules.goods.models.Good;

import java.util.List;

public class Order {
    @JsonProperty("goods")
    List<Good> goods;
}
