package com.liguangda.dao.impl;

import java.util.List;
import java.sql.SQLException;
import com.liguangda.dao.IGoodsDao;
import com.liguangda.utils.MyDBUtils;
import com.liguangda.bean.Goods;

public class GoodsDaoImpl implements IGoodsDao {
     
    @Override
    public List<Goods> getAllGoods() throws SQLException {
        String sql = "SELECT * FROM goods";
        return MyDBUtils.query(sql, null, Goods.class); 
    }

    @Override
    public Goods getGoodsById(int goodsId) throws SQLException {
        String sql = "SELECT * FROM goods WHERE goodsId = ?";   
        return MyDBUtils.queryOne(sql, new Object[]{ goodsId }, Goods.class);
        
    }

    @Override
    public int updateStock(int goodsId, int iStock) throws SQLException {
        String sql = "UPDATE goods SET goodsStock = ? WHERE goodsId = ?";
        return MyDBUtils.update(sql, new Object[]{ iStock, goodsId });
    }
}
