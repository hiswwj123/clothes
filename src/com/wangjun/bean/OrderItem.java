package com.wangjun.bean;

import java.io.Serializable;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/15 0015 22:35
 * ������ϸ��
 */
public class OrderItem implements Serializable {
    private int itemid; //����id
    private Clothes clothes; //��Ʒ
    private int shoppingNum; //��������
    private float sum; //������

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
