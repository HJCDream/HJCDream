package com.hjc.springbootwechatshop.domain;

import lombok.Data;

@Data
public class address {
    private int addressID;
    String userNum;
    String province;
    String city;
    String district;
    String detailedAddress;
    String phoneNum;
    String userName;
}
