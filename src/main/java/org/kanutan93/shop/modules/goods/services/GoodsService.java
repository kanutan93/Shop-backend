package org.kanutan93.shop.modules.goods.services;

import org.kanutan93.shop.modules.goods.models.Good;
import java.util.List;

public interface GoodsService {
    Good createGood(Good good) throws NoSuchFieldException, IllegalAccessException;
    Good updateGood(Good good) throws NoSuchFieldException, IllegalAccessException;
    List<Good> getGoods(String filter, int page);
    void deleteGood(String name);
}
