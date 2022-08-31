package com.hjc.springbootwechatshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.domain.product_sku1;
import com.hjc.springbootwechatshop.service.OrderService;
import com.hjc.springbootwechatshop.service.impl.OderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class orderController {
    @Autowired
    OderServiceImpl oderService;
    @RequestMapping("/insertOrderInfo")
    public void insertOrderInfo(@RequestBody JSONObject orderInfo){
        oderService.insertOrderInfo(orderInfo);
    }
    @RequestMapping("/selectOrderByUser")
    public List<product_sku1> selectOrderByUser(@RequestBody JSONObject userNum){
        String user=userNum.getString("userNum");
        return oderService.selectOderByUser(user);
    }
}
