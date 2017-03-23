package org.kanutan93.shop.modules.base;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.kanutan93.shop.Const;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.reflect.Field;

public class MongoProducer {
    @Produces @MongoGetCollection
    private MongoCollection produceItem(InjectionPoint ip){
        MongoGetCollection mongoGetCollection = ip.getAnnotated().getAnnotation(MongoGetCollection.class);
        MongoClient mongoClient = new MongoClient(new MongoClientURI(Const.URL));
        MongoDatabase mongoDatabase = mongoClient.getDatabase(Const.DB);
        return mongoDatabase.getCollection(mongoGetCollection.collection());
    };

    //TODO мб убрать статику
    public static Document mapToDBEntity(Object item) throws IllegalAccessException, NoSuchFieldException {
        Document document = new Document();
        for(Field field : item.getClass().getDeclaredFields()){
            field.setAccessible(true);
            document.append(field.getName(), field.get(item));
        }
        return document;
    }
}
