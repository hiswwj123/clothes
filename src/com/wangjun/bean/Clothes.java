package com.wangjun.bean;

import java.io.Serializable;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/15 0015 22:34
 * 衣服类,实体类
 */
public class Clothes implements Serializable {
    private String id; //商品id
    private String brand; //品牌
    private String style; //款式
    private String color; //颜色
    private String size; //衣服尺码
    private int num; //库存大小
    private float price; //商品单价
    private String descrption; //商品描述

    public Clothes(String id, String brand, String style, String color, String size, int num, float price, String descrption) {
        this.id = id;
        this.brand = brand;
        this.style = style;
        this.color = color;
        this.size = size;
        this.num = num;
        this.price = price;
        this.descrption = descrption;
    }

    public Clothes() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", style='" + style + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", descrption='" + descrption + '\'' +
                '}';
    }
}
