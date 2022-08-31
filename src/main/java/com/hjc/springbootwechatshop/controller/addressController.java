package com.hjc.springbootwechatshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.domain.address;
import com.hjc.springbootwechatshop.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class addressController {
    @Autowired
    AddressServiceImpl addressService;

    @RequestMapping("/selectAddressById")
    public address selectAddressById(@RequestBody JSONObject id){
        int AddressId=id.getInteger("AddressId");
        return addressService.selectAddressById(AddressId);
    }

    @RequestMapping("/selectAddressByUserNum")
    public List<address> selectAddressByUserNum(@RequestBody JSONObject userNum){
        String user=userNum.getString("userNum");
        return addressService.selectAddressByUserNum(user);
    }
}
