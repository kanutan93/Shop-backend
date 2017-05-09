package org.kanutan93.shop.modules.orders.services;

import com.mongodb.client.MongoCollection;
import org.kanutan93.shop.modules.base.MongoGetCollection;
import org.kanutan93.shop.modules.base.MongoProducer;
import org.kanutan93.shop.modules.orders.models.Order;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class OrderServiceImpl implements OrderService {

    @Inject @MongoGetCollection(collection = "orders")
    private MongoCollection mongoCollection;

    @Override
    public void createOrder(Order order){
        try {
            mongoCollection.insertOne(MongoProducer.mapToDBEntity(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
