package org.kanutan93.shop.modules.users.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.kanutan93.shop.Const;
import org.kanutan93.shop.modules.base.MongoGetCollection;
import org.kanutan93.shop.modules.base.MongoProducer;
import org.kanutan93.shop.modules.users.models.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class UsersServiceImpl implements UsersService {

    @Inject @MongoGetCollection(collection = "users")
    private MongoCollection mongoCollection;

    @Override
    public List<User> getUsers(String filter) {
        List<User> users = new ArrayList<>();
        MongoCursor<User> cursor;
        if(filter != null){
            cursor = mongoCollection.find(Filters.eq("name", filter)).iterator();
        }
        else {
            cursor = mongoCollection.find().iterator();
        }
        try {
            while (cursor.hasNext()) {
                users.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return users;
    }

    @Override
    public User createUser(User user) throws IllegalAccessException, NoSuchFieldException {
        mongoCollection.insertOne(MongoProducer.mapToDBEntity(user));
        return  user;
    }

    @Override
    public User updateUser(User user) throws IllegalAccessException, NoSuchFieldException {
        mongoCollection.updateOne(Filters.eq("name", user.getName()),new Document("$set", MongoProducer.mapToDBEntity(user)));
        return user;
    }

    @Override
    public void deleteUser(String name) {
        mongoCollection.deleteOne(Filters.eq("name", name));
    }
}
