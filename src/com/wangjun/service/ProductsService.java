package com.wangjun.service;

import com.wangjun.bean.Clothes;
import com.wangjun.ui.BusinessException;

import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/19 0019 21:11
 */
public interface ProductsService {
    public  List<Clothes> getProducts()throws BusinessException;
}
