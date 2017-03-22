package org.kanutan93.shop.modules.goods.services;

import org.kanutan93.shop.modules.goods.models.Good;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class GoodsServiceImpl implements GoodsService {
    @Override
    public List<Good> getGoods(String filter) {
        return null;
    }

    @Override
    public Good createGood(Good item) {
        return null;
    }

    @Override
    public Good updateGood(Good item) {
        return null;
    }

    @Override
    public void deleteGood(String name) {

    }
}
