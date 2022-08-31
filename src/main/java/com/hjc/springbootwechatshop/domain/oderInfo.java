package com.hjc.springbootwechatshop.domain;

import lombok.Data;

import java.util.Date;

@Data
public class oderInfo {
    int orderId;
    String orderNum;
    String userNum;
    Date startDate;
    int productId;
    String status;

}
