package com.wangjun.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.wangjun.bean.Clothes;
import com.wangjun.ui.BusinessException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wangjun
 * @Data:Createa in 2019/4/19 0019 17:20
 */
public class PraseProductXmlUtils {
    /**
     * 获取xml内容，获得衣服列表集合
     * @return
     * @throws BusinessException
     */
    public static List<Clothes> getColthes() throws BusinessException {
        List<Clothes> clothes = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",clothes.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");

        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("clothes.xml"));
            clothes = (List<Clothes>) xStream.fromXML(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clothes;
    }

    /**
     * 购买完商品之后，需要更新xml里面的商品数量
     * @param clothes
     */
    public static void writeProductsToXml(List<Clothes> clothes){
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",clothes.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");

        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("clothes"));
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".getBytes());
            xStream.toXML(clothes,out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
