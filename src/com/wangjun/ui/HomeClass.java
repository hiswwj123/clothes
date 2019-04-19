package com.wangjun.ui;

import com.wangjun.bean.Clothes;
import com.wangjun.service.ProductsService;
import com.wangjun.service.impl.ProductsImpl;
import com.wangjun.utils.ConsoleTable;

import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/19 0019 21:08
 */
public class HomeClass extends BaseClass{
    public static void show(){
     showProducts();
     println(getString("info.welcomlogin")+currUser.getUserName());
    }

    public static void showProducts(){
        ProductsService productsService = new ProductsImpl();
        List<Clothes> products = productsService.getProducts();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColum("ID").
                appendColum("brand").
                appendColum("style").
                appendColum("color").
                appendColum("size").
                appendColum("num").
                appendColum("price").
                appendColum("descrption");
        for (Clothes c:products) {
            t.appendRow();
            t.appendColum(c.getId()).
                    appendColum(c.getBrand()).
                    appendColum(c.getStyle()).
                    appendColum(c.getColor()).
                    appendColum(c.getSize()).
                    appendColum(c.getNum()).
                    appendColum(c.getPrice()).
                    appendColum(c.getDescrption());
        }
        System.out.println(t.toString());

    }

}
