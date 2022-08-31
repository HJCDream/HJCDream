package com.hjc.springbootwechatshop.service;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.domain.*;

import java.io.IOException;
import java.util.List;

public interface UserService {
    String InsertUserInfo(JSONObject user) throws IOException;
    List<product_sku1> selectCarByUser(String userNum);
    List<shopCar> findCar(String userNum);
    user selectUserInfo(String userNum);

}
