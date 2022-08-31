package com.hjc.springbootwechatshop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.dao.ProductMapper;
import com.hjc.springbootwechatshop.dao.UserMapper;
import com.hjc.springbootwechatshop.domain.*;
import com.hjc.springbootwechatshop.service.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;
    @Override
    public String InsertUserInfo(JSONObject userInfo) throws IOException {
        user user=new user();
        String code=userInfo.getString("userNum");
        String url="https://api.weixin.qq.com/sns/jscode2session";
        url+="?appid=wxd94c4ca68670be59";//这个和secret都得到微信开发平台里用自己的账号登录后才拿到的
        url+="&secret=2edfbed48e7c9703dc72b69f23fc8a75";
        url+="&js_code="+code;
        url+="&grant_type=authorization_code";
       // url+="&connect_redirect=1";
        String res=null;
        CloseableHttpClient httpClient= HttpClientBuilder.create().build();
        HttpGet httpGet=new HttpGet(url);
        CloseableHttpResponse response = null;
        // 配置信息
        RequestConfig requestConfig = RequestConfig.custom()          // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(5000)                    // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(5000)             // socket读写超时时间(单位毫秒)
                .setSocketTimeout(5000)                    // 设置是否允许重定向(默认为true)
                .setRedirectsEnabled(false).build();           // 将上面的配置信息 运用到这个Get请求里
        httpGet.setConfig(requestConfig);                         // 由客户端执行(发送)Get请求
        response = httpClient.execute(httpGet);                   // 从响应模型中获取响应实体
        HttpEntity responseEntity = response.getEntity();
        System.out.println("响应状态为:" + response.getStatusLine());
        if (responseEntity != null) {
            res = EntityUtils.toString(responseEntity);
            System.out.println("响应内容长度为:" + responseEntity.getContentLength());
            System.out.println("响应内容为:" + res);
        }
        // 释放资源
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
        JSONObject jo = JSON.parseObject(res);
        String openid = jo.getString("openid");
        System.out.println("openid" + openid);
        user.setUserNum(openid);
        user.setUserName(userInfo.getString("userName"));
        user.setUserImage(userInfo.getString("userImage"));
        user.setAddressID(userInfo.getString("userAddressID"));
        user.setPhoneNum(userInfo.getString("phoneNum"));
        userMapper.insertUserInfo(user);
        return openid;
    }

    @Override
    public List<product_sku1> selectCarByUser(String userNum) {
        List<product_sku> car=productMapper.selectCarByUser(userNum);
        //List<String> sku_attrvalue = null;
        List<product_sku1> showCar = new ArrayList<product_sku1>();

//        for (product_sku product_sku : car) {
//            int productID = product_sku.getProductID();
//            //sku_attrvalue=productMapper.findSku_attrvalue(productID);
//            System.out.println(sku_attrvalue);
//            String sku_attrvalueId = productMapper.findSku_attrvalueId(productID);
//            System.out.println(sku_attrvalueId);
//            System.out.println(product_sku);
//        }
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

    @Override
    public List<shopCar> findCar(String userNum) {
        return productMapper.findCar(userNum);
    }

    @Override
    public user selectUserInfo(String userNum) {
        return userMapper.selectUserInfo(userNum);
    }
}
