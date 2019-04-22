package com.wangjun.utils;

import com.wangjun.bean.Clothes;
import com.wangjun.ui.BusinessException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/22 0022 15:40
 */
public class ClothesIO {
    public static List<Clothes> clothes = new ArrayList<>(); //定义一个存放衣服的集合

    public static Clothes findClothesById(String cid)throws BusinessException{
        for (Clothes c:clothes){
            if(cid.equals(c.getId())){
                return c;
            }
        }
        return null;
    }

    public static List<Clothes> findClothes()throws BusinessException{
        if(clothes.size() == 0){
            clothes = PraseProductXmlUtils.getColthes();
        }
        return clothes;
    }

    /**
     * 更新xml文件
     * @throws BusinessException
     */
    public static void updateXml()throws BusinessException{
        PraseProductXmlUtils.writeProductsToXml(clothes);
    }
}
