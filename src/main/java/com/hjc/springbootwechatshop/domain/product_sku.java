package com.hjc.springbootwechatshop.domain;

import lombok.Data;

@Data
public class product_sku {
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
}
