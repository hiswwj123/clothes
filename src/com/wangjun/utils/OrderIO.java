package com.wangjun.utils;

import com.wangjun.bean.Order;
import com.wangjun.ui.BusinessException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/22 0022 15:40
 */
public class OrderIO {

    public static List<Order> orders = new ArrayList<>();
    public static String ORDER_FILE = "order.obj";

    /**
     * ���������浽�ļ���
     * @throws BusinessException
     */
    public static void writeOreders() throws BusinessException {
        try {
            ObjectOutputStream  out = new ObjectOutputStream(new FileOutputStream(ORDER_FILE));
            out.writeObject(orders);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���ļ��ж�ȡ������Ϣ
     * @return
     * @throws BusinessException
     */
    public static Boolean readOrders()throws BusinessException{
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ORDER_FILE));
            orders = ((List<Order>) in.readObject());
            in.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * ���ݶ���Id����ѯ����
     * @param oid
     * @return
     */
    public Order findOrderById(int oid){
       for (Order o : orders){
           int orderId = o.getOrderId();
           if(oid == orderId ){
               return o;
           }
       }
       return null;
    }

    /**
     * ��ѯ���ж���
     * @return
     * @throws BusinessException
     */
    public List<Order> findOrders()throws BusinessException{
        return orders;
    }

    /**
     * ��order����浽orders������
     * @param order
     */
    public void add(Order order){
        orders.add(order);
    }


}
