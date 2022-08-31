package com.hjc.springbootwechatshop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString
public class product_spu {
    private int ProductIDspu;//很奇特，如果有了下滑线，那从数据库得到的ProductID_spu只会是0，但把名字换了后就一切正常了
    private String ProductName;
    private String[] ProductPhoto;
    private String Classify;
    private int Status;
    private double Price;
    private String[] attr_key;
    private String[][] attr_value;

//    public int getProductID_spu() {
//        return ProductID_spu;
//    }
//
//    public void setProductIDspu(int productID_spu) {//更神奇的事情发生了，当ProductID_spu还存在下划线的时候,只要把get set方法里的setProductID_spu的下划线去掉，其他不用变那从数据库里拿到的数据也会变回正常，否则就还是0
//                                                        //而如果本身ProductIDspu就不带下划线，那哪怕set方法名字有下划线也不会影响到关联数据库的值
//        ProductID_spu = productID_spu;
//    }
//
//    public String getProductName() {
//        return ProductName;
//    }
//
//    public void setProductName(String productName) {
//        ProductName = productName;
//    }
//
    public String[] getProductPhoto() {
        return ProductPhoto;
    }

    public void setProductPhoto(String[] productPhoto) {
        ProductPhoto = productPhoto;
    }
//
//    public String getClassify() {
//        return Classify;
//    }
//
//    public void setClassify(String classify) {
//        Classify = classify;
//    }
//
//    public int getStatus() {
//        return Status;
//    }
//
//    public void setStatus(int status) {
//        Status = status;
//    }
//
//    public double getPrice() {
//        return Price;
//    }
//
//    public void setPrice(double price) {
//        Price = price;
//    }
//
//    public String[] getAttr_key() {
//        return attr_key;
//    }
//
//    public void setAttr_key(String[] attr_key) {
//        this.attr_key = attr_key;
//    }
//
//    public String[] getAttr_value() {
//        return attr_value;
//    }
//
//    public void setAttr_value(String[] attr_value) {
//        this.attr_value = attr_value;
//    }
//
//    @Override
//    public String toString() {
//        return "product_spu{" +
//                "ProductID_spu=" + ProductID_spu +
//                ", ProductName='" + ProductName + '\'' +
//                ", ProductPhoto=" + Arrays.toString(ProductPhoto) +
//                ", Classify='" + Classify + '\'' +
//                ", Status=" + Status +
//                ", Price=" + Price +
//                '}';
//    }
}
