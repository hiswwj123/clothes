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
     * 获取xml内容，获取到衣服列表
     * @return
     * @throws BusinessException
     */
    public static List<Clothes> getColthes() throws BusinessException {
        List<Clothes> products = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");

        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("clothes.xml"));
            products = (List<Clothes>) xStream.fromXML(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void writeProductsToXml(List<Clothes> products){
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");

        try {
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("clothes"));
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>".getBytes());
            xStream.toXML(products,out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
