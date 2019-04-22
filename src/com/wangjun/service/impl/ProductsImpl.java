package com.wangjun.service.impl;

import com.wangjun.bean.Clothes;
import com.wangjun.service.ProductsService;
import com.wangjun.ui.BusinessException;
import com.wangjun.utils.ClothesIO;
import com.wangjun.utils.PraseProductXmlUtils;

import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/19 0019 21:13
 */
public class ProductsImpl implements ProductsService {

    /**
     * 直接调用工具类来获取产品
     * @return
     * @throws BusinessException
     */
    @Override
    public  List<Clothes> getClothes() throws BusinessException {
        List<Clothes> colthes = PraseProductXmlUtils.getColthes();
        return colthes;
    }

    @Override
    public Clothes findClothesById(String id) throws BusinessException {
        Clothes clothesById = ClothesIO.findClothesById(id);
        return clothesById;
    }
}
