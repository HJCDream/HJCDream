package com.hjc.springbootwechatshop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class product {
    private int productid;
    private String productname;
    private String[] attr_key;
    private String souce;
    private double price;
    private int inventory;
    private String[][] attr_value;
    private String label;
    private int status;
    private int productspuid;
//    public int getProductid() {
//        return productid;
//    }
//
//    public void setProductid(int productid) {
//        this.productid = productid;
//    }
//
//    public String getProductname() {
//        return productname;
//    }
//
//    public void setProductname(String productname) {
//        this.productname = productname;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getSouce() {
//        return souce;
//    }
//
//    public void setSouce(String souce) {
//        this.souce = souce;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public int getInventory() {
//        return inventory;
//    }
//
//    public void setInventory(int inventory) {
//        this.inventory = inventory;
//    }
//
//    public String getSpecification() {
//        return specification;
//    }
//
//    public void setSpecification(String specification) {
//        this.specification = specification;
//    }
//
//    public String getLabel() {
//        return label;
//    }
//
//    public void setLabel(String label) {
//        this.label = label;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public int getProductspuid() {
//        return productspuid;
//    }
//
//    public void setProductspuid(int productspuid) {
//        this.productspuid = productspuid;
//    }
//
//    @Override
//    public String toString() {
//        return "product{" +
//                "productid=" + productid +
//                ", productname='" + productname + '\'' +
//                ", description='" + description + '\'' +
//                ", souce='" + souce + '\'' +
//                ", price=" + price +
//                ", inventory=" + inventory +
//                ", specification='" + specification + '\'' +
//                ", label='" + label + '\'' +
//                ", status=" + status +
//                ", productspuid=" + productspuid +
//                '}';
//    }
}
