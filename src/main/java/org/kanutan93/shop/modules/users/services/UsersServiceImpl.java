package org.kanutan93.shop.modules.users.services;
import com.mongodb.client.FindIterable;
import org.kanutan93.shop.modules.base.MongoCollection;
import org.kanutan93.shop.modules.base.MongoConnectionProducer;
import org.kanutan93.shop.modules.users.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.client.model.*;

@Named
@RequestScoped
public class UsersServiceImpl implements UsersService {

    @Inject
    @MongoCollection(collection = "users")
    private MongoConnectionProducer mongoConnectionProducer;

    @Override
    public List<User> getUsers(String filter) {
        List<User> response = new ArrayList<User>();
        FindIterable<User> users = mongoConnectionProducer.getCollection().find(Filters.eq("name",filter));
        for(User user : users){
            response.add(user);
        }
        return response;
    }

    @Override
    public User createUser(User item) {
        return null;
    }

    @Override
    public User updateUser(User item) {
        return null;
    }

    @Override
    public void deleteUser(String name) {

    }
}
