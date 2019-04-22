package com.wangjun.service;

import com.wangjun.bean.Order;
import com.wangjun.ui.BusinessException;

import java.nio.BufferOverflowException;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/22 0022 16:19
 */
public interface OrderService {
    public void byproduct(Order order)throws BusinessException;
    public List<Order> findOrder()throws BusinessException;
    public Order findOrderById(int oid)throws BusinessException;
}
