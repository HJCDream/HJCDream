package com.hjc.springbootwechatshop.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class user {
    private int userID;
    private String userName;
    private String userNum;
    private String phoneNum;
    private String addressID;
    private String userImage;
}
