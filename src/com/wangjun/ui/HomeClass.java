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
    public static StringBuilder stringBuilder = new StringBuilder(); //由于使用+比较容易造成资源浪费
    /**
     * 显示主页面的功能
     */
    public static void show(){
     showProducts();
     println(stringBuilder.append(getString("info.welcomlogin")).append(currUser.getUserName()).toString());
     menu();
    }

    /**
     * 显示菜单
     */
    public static void menu() {
        boolean flag = true;
        while (flag){
            println(getString("product.feature"));
            println(getString("info.select"));
            String select = input.next();
            //处理功能
            switch(select){
                case "1": //查询所有订单
                    findProducts();
                    flag = false;
                    break;
                case "2": //根据id来查询
                    findProductById();
                    flag = false;
                    break;
                case "3": //购买功能
                    buyProduct();
                    flag = false;
                    break;
                case "4": //显示商品
                    show();
                    flag = false;
                    break;
                case "0": //退出系统
                    System.exit(0);
                    flag = false;
                    println(getString("system.exit"));
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }

    /**
     * 查询所有订单
     */
    private static void findProducts() {
        List<Order> orders = orderService.findOrder(); //返回所有订单
        for (Order o:orders) {
            showOrder(o);
        }
        menu();
    }

    private static void showOrder(Order order) {
        print(getString("product.order.id")+order.getOrderId());
        print(getString("product.order.createdate")+order.getCreateDate());
        println(getString("product.order.sum")+order.getSum());
        ConsoleTable t = new ConsoleTable(9, true);
        t.appendRow();
        t.appendColum("itemid").
                appendColum("brand").
                appendColum("style").
                appendColum("color").
                appendColum("size").
                appendColum("price").
                appendColum("shoppingNum").
                appendColum("descrption").
                appendColum("sum");
       for(OrderItem orderItem :order.getList()){
           t.appendRow();
           t.appendColum(orderItem.getItemid()).
                   appendColum(orderItem.getClothes().getBrand()).
                   appendColum(orderItem.getClothes().getStyle()).
                   appendColum(orderItem.getClothes().getColor()).
                   appendColum(orderItem.getClothes().getSize()).
                   appendColum(orderItem.getClothes().getPrice()).
                   appendColum(orderItem.getShoppingNum()).
                   appendColum(orderItem.getClothes().getDescrption()).
                   appendColum(orderItem.getSum());
       }
       println(t.toString());
    }

    /**
     * 查找订单
     */
    private static void findProductById() {
        println(getString("product.id"));
        int orderid = input.nextInt();
        List<Order> order = orderService.findOrder();
        for (Order o:order){
            if(orderid == o.getOrderId()){
                showOrder(o);
            }
        }
    }

    /**
     * 购买商品
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
           order.getList().add(orderItem); //将订单明细存到订单中，便于生成订单
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
       order.setOrderId(orderService.finOrder1().size()+1);

       orderService.byproduct(order);
       //买完之后就要进行库存减少
       productsService.update();
       menu();
    }

    /**
     * 展示产品列表
     */
    public static void showProducts(){
        ProductsService productsService = new ProductsImpl();
        List<Clothes> products = productsService.getClothes(); //获取衣服列表
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
        println(t.toString());

    }

}
