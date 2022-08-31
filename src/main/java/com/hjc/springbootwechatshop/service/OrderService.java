package com.hjc.springbootwechatshop.service;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.domain.product_sku1;

import java.util.List;

public interface OrderService {
    public String getTime();
    public int randNum();
    public String insertOrderInfo(JSONObject orderInfo);
    public List<product_sku1> selectOderByUser(String userNum);
}
