package com.wangjun.service.impl;

import com.wangjun.bean.Order;
import com.wangjun.service.OrderService;
import com.wangjun.ui.BusinessException;
import com.wangjun.utils.OrderIO;

import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/22 0022 16:22
 */
public class OrderServiceImpl implements OrderService {
    public static OrderIO orderIO = new OrderIO();

    @Override
    public void byproduct(Order order) throws BusinessException {
        orderIO.add(order);
    }

    @Override
    public List<Order> findOrder() throws BusinessException {
        List<Order> orders = orderIO.findOrders();
        return orders;
    }

    @Override
    public Order findOrderById(int oid) throws BusinessException {
        Order orderById = orderIO.findOrderById(oid);
        return orderById;
    }
}
