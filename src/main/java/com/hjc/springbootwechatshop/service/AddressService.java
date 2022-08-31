package com.hjc.springbootwechatshop.service;

import com.hjc.springbootwechatshop.domain.address;

import java.util.List;

public interface AddressService {
    public address selectAddressById(int id);
    public List<address> selectAddressByUserNum(String userNum);
}
