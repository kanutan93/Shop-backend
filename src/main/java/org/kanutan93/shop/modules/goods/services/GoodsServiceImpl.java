package org.kanutan93.shop.modules.goods.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.kanutan93.shop.Const;
import org.kanutan93.shop.modules.base.MongoGetCollection;
import org.kanutan93.shop.modules.base.MongoProducer;
import org.kanutan93.shop.modules.goods.models.Good;
import org.kanutan93.shop.modules.users.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class GoodsServiceImpl implements GoodsService {
    @Inject
    @MongoGetCollection
    MongoCollection mongoCollection;

    @Override
    public List<Good> getGoods(String filter, int page) {
        List<Good> goods = new ArrayList<>();
        MongoCursor<Good> cursor;
        if (filter != null){
             cursor = mongoCollection.find(Filters.eq("name", filter))
                     .skip((page - 1) * Const.maxGoodsOnPage)
                     .limit(Const.maxGoodsOnPage)
                     .iterator();
        }
        else  {
            cursor = mongoCollection.find()
                    .skip((page - 1) * Const.maxGoodsOnPage)
                    .limit(Const.maxGoodsOnPage)
                    .iterator();
        }
        try {
            while (cursor.hasNext()) {
                goods.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return goods;
    }

    @Override
    public Good createGood(Good good) throws NoSuchFieldException, IllegalAccessException {
        mongoCollection.insertOne(MongoProducer.mapToDBEntity(good));
        return  good;
    }

    @Override
    public Good updateGood(Good good) throws NoSuchFieldException, IllegalAccessException {
        mongoCollection.updateOne(Filters.eq("name", good.getName()),new Document("$set", MongoProducer.mapToDBEntity(good)));
        return good;
    }

    @Override
    public void deleteGood(String name) {
        mongoCollection.deleteOne(Filters.eq("name", name));
    }
}
