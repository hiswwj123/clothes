package com.wangjun.service.impl;

import com.wangjun.bean.Clothes;
import com.wangjun.service.ProductsService;
import com.wangjun.ui.BusinessException;
import com.wangjun.utils.PraseProductXmlUtils;

import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/19 0019 21:13
 */
public class ProductsImpl implements ProductsService {

    @Override
    public  List<Clothes> getProducts() throws BusinessException {
        List<Clothes> colthes = PraseProductXmlUtils.getColthes();
        return colthes;
    }
}
