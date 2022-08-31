package com.hjc.springbootwechatshop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.dao.OrderMapper;
import com.hjc.springbootwechatshop.dao.ProductMapper;
import com.hjc.springbootwechatshop.domain.oderInfo;
import com.hjc.springbootwechatshop.domain.product_sku;
import com.hjc.springbootwechatshop.domain.product_sku1;
import com.hjc.springbootwechatshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class OderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ProductMapper productMapper;
    @Override
    public String getTime(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        return dateFormat.format(new Date());
    }
    @Override
    public int randNum(){
        Random random=new Random();
        return random.nextInt(99999)+10000;
    }
    @Override
    public String insertOrderInfo(JSONObject orderInfo) {
        oderInfo orderInfor=new oderInfo();
        orderInfor.setProductId(orderInfo.getInteger("productId"));
        orderInfor.setUserNum(orderInfo.getString("userNum"));
        String time = getTime().replaceAll("[[\\s-:punct:]]", "");
        int randNum = randNum();
        String timeAndRand=time+randNum;//把时间戳是随机数平凑在一起形成订单号
        orderInfor.setOrderNum(timeAndRand);
        orderInfor.setStatus("购买成功");
        orderMapper.insertOrderInfo(orderInfor);
        return "订单插入成功";
    }

    @Override
    public List<product_sku1> selectOderByUser(String userNum) {
            List<product_sku> car=productMapper.selectOrderByUser(userNum);
            //List<String> sku_attrvalue = null;
            List<product_sku1> showCar = new ArrayList<product_sku1>();
            for (product_sku product_sku : car) {
                product_sku1 sku1=new product_sku1();
                int productID = product_sku.getProductID();
                String attr_value = productMapper.findSku_attrvalueId(productID);
                List<String> attrvalue = productMapper.selectAttrvalue(attr_value);

                String attrvalue2 = attrvalue.stream().map(s -> "\'" + s + "\'").collect(Collectors.joining(","));//把list里面的每个元素加上单引号并用逗号隔开
                //String.join(",", attrvalue);
                System.out.println("attrvalue2:"+attrvalue2);
                String img = productMapper.selectImgByAttrvalue(attrvalue2);
                sku1.setAttr_value(attrvalue2);
                sku1.setImg(img);
                sku1.setAttr_key(product_sku.getAttr_key());
                sku1.setInventory(product_sku.getInventory());
                sku1.setLabel(product_sku.getLabel());
                sku1.setPrice(product_sku.getPrice());
                sku1.setProductID(product_sku.getProductID());
                sku1.setProductName(product_sku.getProductName());
                sku1.setSouce(product_sku.getSouce());
                sku1.setProductSpuID(product_sku.getProductSpuID());
                sku1.setStatus(product_sku.getStatus());
                System.out.println("sku1"+sku1);
                System.out.println("here");
                showCar.add(sku1);
            }
            return showCar;

    }
}
