package com.liguangda.dao;

import java.sql.SQLException;
import java.util.List;
import com.liguangda.bean.Goods;

public interface IGoodsDao {
     
    public List<Goods> getAllGoods() throws SQLException;
    public Goods getGoodsById(int goodsId) throws SQLException;
    public int updateStock(int goodsId, int iStock) throws SQLException;
}
