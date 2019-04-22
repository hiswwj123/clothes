package com.wangjun.ui;

import com.wangjun.bean.Clothes;
import com.wangjun.bean.OrderItem;
import com.wangjun.service.ProductsService;
import com.wangjun.service.impl.ProductsImpl;
import com.wangjun.utils.ConsoleTable;

import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/19 0019 21:08
 * 主界面类
 */
public class HomeClass extends BaseClass{
    /**
     * 显示主页面的功能
     */
    public static void show(){
     showProducts();
     println(getString("info.welcomlogin")+currUser.getUserName());
     println(getString("product.feature"));
     String select = input.next();
     //处理功能
     switch(select){
         case "1": //查询所有订单
             findProducts();
             break;
         case "2": //根据id来查询
             findProductById();
             break;
         case "3": //购买功能
             buyProduct();
             break;
         case "0": //退出系统
             System.exit(0);
             break;
         default:
             println(getString("input.error"));
             break;
     }



    }

    /**
     * 查询所有订单
     */
    private static void findProducts() {

    }

    /**
     * 查找订单
     */
    private static void findProductById() {

    }

    /**
     * 购买的方法
     */
    private static void buyProduct() {
       boolean flag = true;
        //生成订单的方法
       while (flag){
           println(getString("input.productId"));
           String cid = input.next();
           println(getString("input.productnum"));
           String num = input.next();

           OrderItem orderItem = new OrderItem();

           println(getString("input.jixu"));
           String isBuy = input.next();
           switch(isBuy){
               case "1":
                   flag = true;
                   break;
               case "2":
                   flag = false;
                   break;
               default:
                   println(getString("input.error"));
                   break;
           }
       }

    }

    public static void showProducts(){
        ProductsService productsService = new ProductsImpl();
        List<Clothes> products = productsService.getClothes();
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
