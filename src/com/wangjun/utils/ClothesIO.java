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
            String id = c.getId();
            if(cid == id){
                return c;
            }
        }
        return null;
    }

    public static List<Clothes> findClothes()throws BusinessException{
        clothes = PraseProductXmlUtils.getColthes();
        return clothes;
    }

}
