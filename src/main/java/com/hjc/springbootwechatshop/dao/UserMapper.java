package com.hjc.springbootwechatshop.dao;

import com.hjc.springbootwechatshop.domain.product_spu1;
import com.hjc.springbootwechatshop.domain.shopCar;
import com.hjc.springbootwechatshop.domain.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    public void insertUserInfo(user user);

//    public List<product_spu1> selectCarByUser(int userid);
    public user selectUserInfo(String userNum);

}
