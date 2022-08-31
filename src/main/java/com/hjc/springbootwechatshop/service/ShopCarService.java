package com.hjc.springbootwechatshop.service;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.domain.shopCar;

public interface ShopCarService {
    public String putInCar(shopCar shopCar);
    public String updateCar(String select,int productId);
    public void deleteProduct(JSONObject productInfo);
}
