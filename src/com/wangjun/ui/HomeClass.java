package com.wangjun.ui;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.wangjun.bean.Clothes;
import com.wangjun.bean.Order;
import com.wangjun.bean.OrderItem;
import com.wangjun.service.OrderService;
import com.wangjun.service.ProductsService;
import com.wangjun.service.impl.OrderServiceImpl;
import com.wangjun.service.impl.ProductsImpl;
import com.wangjun.utils.ConsoleTable;
import com.wangjun.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/19 0019 21:08
 * 主界面类
 */
public class HomeClass extends BaseClass{
    public static ProductsService productsService = new ProductsImpl(); //购买商品的类
    public static OrderService orderService = new OrderServiceImpl();
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
       int count = 1;
       Order order = new Order();
       float sum = 0.0f;
        //生成订单的方法
       while (flag){
           println(getString("input.productId"));
           String cid = input.next();
           println(getString("input.productnum"));
           String num = input.next();

           Clothes clothesById = productsService.findClothesById(cid);
           int shoppingNum = Integer.parseInt(num);
           //判断购买数量是否大于库存数量
           if(shoppingNum>clothesById.getNum()){
               throw new BusinessException("product.kucu");
           }
           clothesById.setNum(clothesById.getNum()-shoppingNum); //减去库存
           //生成订单详细
           OrderItem orderItem = new OrderItem();

           orderItem.setShoppingNum(shoppingNum);
           orderItem.setClothes(clothesById);
           orderItem.setSum(clothesById.getPrice()*shoppingNum);
           orderItem.setItemid(count++);
           order.getList().add(orderItem);
           sum +=orderItem.getSum(); //计算的是订单总金额
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
       order.setSum(sum);
       order.setUserId(currUser.getId());
       order.setCreateDate(DateUtils.toDate(new Date()));
       order.setOrderId(orderService.findOrder().size()+1);

       orderService.byproduct(order);
       //买完之后就要进行库存减少
       productsService.update();
       showProducts();
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
