package com.liguangda.service.impl;

import java.util.List;
import java.sql.SQLException;
import com.liguangda.dao.IGoodsDao;
import com.liguangda.dao.impl.GoodsDaoImpl;
import com.liguangda.service.IGoodsService;
import com.liguangda.bean.Goods;

public class GoodsServiceImpl implements IGoodsService {

    private IGoodsDao iGoodsDao = new GoodsDaoImpl();

    @Override 
    public List<Goods> getAllGoods() throws SQLException {
        return iGoodsDao.getAllGoods(); 
    }

    @Override
    public Goods getGoodsById(int goodsId) throws SQLException {
        return iGoodsDao.getGoodsById(goodsId); 
    }

    @Override
    public int updateStock(int goodsId, int iStock) throws SQLException {
        return iGoodsDao.updateStock(goodsId, iStock);
    }
}
