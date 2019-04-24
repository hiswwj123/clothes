package com.wangjun.bean;

import java.io.Serializable;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/15 0015 22:35
 * 订单明细类
 */
public class OrderItem implements Serializable {
    private int itemid; //订单id
    private Clothes clothes; //商品
    private int shoppingNum; //购买数量
    private float sum; //购买金额

    public OrderItem(int itemid, Clothes clothes, int shoppingNum, float sum) {
        this.itemid = itemid;
        this.clothes = clothes;
        this.shoppingNum = shoppingNum;
        this.sum = sum;
    }

    public OrderItem() {
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public int getShoppingNum() {
        return shoppingNum;
    }

    public void setShoppingNum(int shoppingNum) {
        this.shoppingNum = shoppingNum;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
