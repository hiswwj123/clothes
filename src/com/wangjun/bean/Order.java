package com.wangjun.bean;

import com.wangjun.utils.OrderStausType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/15 0015 22:34
 * ������
 * �Ͷ�����ϸ����һ�Զ�Ĺ�ϵ
 */
public class Order implements Serializable {

    private int orderId;
    private List<OrderItem> list = new ArrayList<>();
    private float sum; //�ܽ��
    private OrderStausType staus = OrderStausType.UNPAID; //����״̬
    private int userId;
    private String createDate; //�����Ĵ�ӡʱ��

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Order(int orderId, List<OrderItem> list, float sum, OrderStausType staus, int userId) {
        this.orderId = orderId;
        this.list = list;
        this.sum = sum;
        this.staus = staus;
        this.userId = userId;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public OrderStausType getStaus() {
        return staus;
    }

    public void setStaus(OrderStausType staus) {
        this.staus = staus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
