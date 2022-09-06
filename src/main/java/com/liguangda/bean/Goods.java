package com.liguangda.bean;

public class Goods {

    private int goodsId;
    private String goodsName;
    private String goodsBrand;
    private String goodsCategory;
    private double goodsPrice;
    private int goodsStock;
    private String goodsPicture;
    private String goodsFeature;

    public Goods() {}

    public Goods(int goodsId, String goodsName, String goodsBrand, String goodsCategory, 
                 double goodsPrice, int goodsStock, String goodsPicture, String goodsFeature) {
        this.goodsId = goodsId;         
        this.goodsName = goodsName;         
        this.goodsBrand = goodsBrand;         
        this.goodsCategory = goodsCategory;         
        this.goodsPrice = goodsPrice;         
        this.goodsStock = goodsStock;         
        this.goodsPicture = goodsPicture;         
        this.goodsFeature = goodsFeature;         
    }

    public int getGoodsId() { return goodsId; }

    public void setGoodsId(int goodsId) { this.goodsId = goodsId; }

    public String getGoodsName() { return goodsName; }

    public void setGoodsName(String goodsName) { this.goodsName = goodsName; }

    public String getGoodsBrand() { return goodsBrand; }

    public void setGoodsBrand(String goodsBrand) { this.goodsBrand = goodsBrand; }

    public String getGoodsCategory() { return goodsCategory; }

    public void setGoodsCategory(String goodsCategory) { this.goodsCategory = goodsCategory; }

    public double getGoodsPrice() { return goodsPrice; }

    public void setGoodsPrice(double goodsPrice) { this.goodsPrice = goodsPrice; }

    public int getGoodsStock() { return goodsStock; }

    public void setGoodsStock(int goodsStock) { this.goodsStock = goodsStock; }

    public String getGoodsPicture() { return goodsPicture; }

    public void setGoodsPicture(String goodsPicture) { this.goodsPicture = goodsPicture; }

    public String getGoodsFeature() { return goodsFeature; }

    public void setGoodsFeature(String goodsFeature) { this.goodsFeature = goodsFeature; }

    @Override
    public String toString() {
        return "Goods{" + 
               "goodsId='" + goodsId + '\'' +
               ", goodsName='" + goodsName + '\'' +
               ", goodsBrand='" + goodsBrand + '\'' +
               ", goodsCategory='" + goodsCategory + '\'' +
               ", goodsPrice='" + goodsPrice + '\'' +
               ", goodsStock='" + goodsStock + '\'' +
               ", goodsPicture='" + goodsPicture + '\'' +
               ", goodsFeature='" + goodsFeature + '\'' +
               '}';
    }
}
