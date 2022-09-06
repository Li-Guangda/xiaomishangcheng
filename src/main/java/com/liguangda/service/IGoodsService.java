package com.liguangda.service;

import java.util.List;
import java.sql.SQLException;
import com.liguangda.bean.Goods;

public interface IGoodsService {
     
    public List<Goods> getAllGoods() throws SQLException;

    public Goods getGoodsById(int goodsId) throws SQLException;

    public int updateStock(int goodsId, int iStock) throws SQLException;
}
