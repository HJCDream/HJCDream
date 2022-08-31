package com.hjc.springbootwechatshop.dao;

import com.hjc.springbootwechatshop.domain.oderInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public void insertOrderInfo(oderInfo oderInfo);
}
