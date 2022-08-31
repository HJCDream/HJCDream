package com.hjc.springbootwechatshop.dao;

import com.hjc.springbootwechatshop.domain.address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    public address selectAddressByid(int id);
    public List<address> selectAddressByUserNum(String num);
}
