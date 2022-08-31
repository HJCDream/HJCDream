package com.hjc.springbootwechatshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.domain.product_sku1;
import com.hjc.springbootwechatshop.domain.product_spu1;
import com.hjc.springbootwechatshop.domain.shopCar;
import com.hjc.springbootwechatshop.domain.user;
import com.hjc.springbootwechatshop.service.impl.ShopCarServiceImpl;
import com.hjc.springbootwechatshop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    ShopCarServiceImpl shopCarService;
    @RequestMapping("/login")
    public String login(@RequestBody JSONObject userInfo) throws IOException {

        return userService.InsertUserInfo(userInfo);

    }
    @RequestMapping("/selectCarByUser")
    public List<product_sku1> selectCarByUser(@RequestBody JSONObject userInfo){
        String userNum=userInfo.getString("userNum");
        return userService.selectCarByUser(userNum);
    }
    @RequestMapping("/putInCar")
    public String putInCar(@RequestBody JSONObject productAndUserInfo){
        shopCar shopCar=new shopCar();
        shopCar.setProductId(productAndUserInfo.getInteger("productId"));
        shopCar.setProductName(productAndUserInfo.getString("productName"));
        shopCar.setUserNum(productAndUserInfo.getString("userNum"));
        shopCar.setCount(Integer.valueOf(productAndUserInfo.getString("count")));
        shopCar.setSelect("circle");
        return shopCarService.putInCar(shopCar);
    }
    @RequestMapping("/findCar")
    public List<shopCar> findCar(@RequestBody JSONObject userInfo){
        String userNum=userInfo.getString("userNum");
        return userService.findCar(userNum);
    }
    @RequestMapping("/updateCar")
    public String updateCar(@RequestBody JSONObject select){
        String selectStaus=select.getString("select");
        int productId=select.getInteger("productId");
        return shopCarService.updateCar(selectStaus,productId);

    }
    @RequestMapping("/deleteProduct")
    public String deleteProduct(@RequestBody JSONObject productInfo){
        shopCarService.deleteProduct(productInfo);
        return "删除成功";

    }

    @RequestMapping("/selectUserInfo")
    public user selectUserInfo(@RequestBody JSONObject userInfo){
        String userNum=userInfo.getString("userNum");
        return userService.selectUserInfo(userNum);
    }

}
