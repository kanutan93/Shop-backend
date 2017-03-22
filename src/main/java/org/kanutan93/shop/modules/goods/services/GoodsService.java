package org.kanutan93.shop.modules.goods.services;

import org.kanutan93.shop.modules.goods.models.Good;
import java.util.List;

public interface GoodsService {
    Good createGood(Good item);
    Good updateGood(Good item);
    List<Good> getGoods(String filter);
    void deleteGood(String name);
}
