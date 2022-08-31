package com.hjc.springbootwechatshop.domain;

import lombok.Data;
import lombok.ToString;

@Data
public class shopCar {
    private int shopCarId;
    private String userNum;
    private String productName;
    private int productId;
    private int count;
    private String select;
}
