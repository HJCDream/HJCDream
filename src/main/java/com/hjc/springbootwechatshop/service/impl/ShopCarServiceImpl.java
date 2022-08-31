package com.hjc.springbootwechatshop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.dao.ShopCarMapper;
import com.hjc.springbootwechatshop.domain.shopCar;
import com.hjc.springbootwechatshop.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Resource
    ShopCarMapper shopCarMapper;
    @Override
    public String putInCar(shopCar shopCar) {
        shopCarMapper.putInCar(shopCar);
        return "ok";
    }

    @Override
    public String updateCar(String select, int productId) {
        shopCarMapper.updateSelect(select,productId);
        return "更新成功";
    }

    @Override
    public void deleteProduct(JSONObject productInfo) {
        int productId=productInfo.getInteger("productId");
        String userNum=productInfo.getString("userNum");
        shopCarMapper.deleteProduct(productId,userNum);
    }
}
