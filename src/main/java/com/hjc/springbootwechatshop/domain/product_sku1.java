package com.hjc.springbootwechatshop.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class product_sku1 {
    private int ProductID;
    private String ProductName;
    private String attr_key;
    private String Souce;
    private double Price;
    private int Inventory;
    private String attr_value;
    private String Label;
    private int Status;
    private int ProductSpuID;
    private String img;
}
