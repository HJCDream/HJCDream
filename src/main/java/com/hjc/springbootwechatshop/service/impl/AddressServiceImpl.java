package com.hjc.springbootwechatshop.service.impl;

import com.hjc.springbootwechatshop.dao.AddressMapper;
import com.hjc.springbootwechatshop.domain.address;
import com.hjc.springbootwechatshop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public address selectAddressById(int id) {

        return addressMapper.selectAddressByid(id);
    }

    @Override
    public List<address> selectAddressByUserNum(String userNum) {
        return addressMapper.selectAddressByUserNum(userNum);
    }
}
