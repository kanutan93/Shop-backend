package org.kanutan93.shop.modules.base;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.kanutan93.shop.Const;

public class MongoConnectionProducer {
    private MongoCollection collection;

    public MongoConnectionProducer(String collection){
        MongoClient mongoClient = new MongoClient(new MongoClientURI(Const.URL));
        MongoDatabase mongoDatabase = mongoClient.getDatabase(Const.DB);
        this.collection = mongoDatabase.getCollection(collection);
    }

    public MongoCollection getCollection() {
        return collection;
    }
}
