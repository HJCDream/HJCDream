package com.hjc.springbootwechatshop.dao;

import com.hjc.springbootwechatshop.domain.shopCar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopCarMapper {
    //把商品加入购物车
    public void putInCar(shopCar shopCar);
    public void updateSelect(@Param("select") String select, @Param("productId") int productId);
    public void deleteProduct(@Param("productId") int productId,@Param("userNum") String userNum);
}
