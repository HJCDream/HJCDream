package com.hjc.springbootwechatshop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class product_spu1 {
    private int ProductIDspu;//很奇特，如果有了下滑线，那从数据库得到的ProductID_spu只会是0，但把名字换了后就一切正常了
    private String ProductName;
    private String ProductPhoto;
    private String Classify;
    private int Status;
    private double Price;
    private String[] attr_key;
    private String[][] attr_value;
}
