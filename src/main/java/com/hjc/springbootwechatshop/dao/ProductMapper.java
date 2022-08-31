package com.hjc.springbootwechatshop.dao;

import com.hjc.springbootwechatshop.domain.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProductMapper {
    //查询全部商品
    @Select("select * from product_spu")
    public List<product_spu1> findAllProduct();

    //查询全部商品
    @Select("select * from product_spu LIMIT 5")
    public List<product_spu1> findAllHot();

    //根据分类查询商品
//    @Select("select ProductName,ProductPhoto from product where Classify=#{classify}")
    @Select("select * from product_spu where Classify in (select ClassifyID from classify where Classify=#{classify})")
    public List<product_spu1> findProductByClassify(String classify);
    //点入商品详情
    @Select("select * from product_sku where productspuid=#{productspuid} limit 1")
    public product findProductByProductSpuID(int productspuid);

    //同一个SPU产品里的所有SKU商品
    @Select("select * from product_sku where productspuid=#{productspuid}")
    public List<product> findProductByProductSpuIDALL(int productspuid);

    //商品详情里的banner//不仅为了banner还是为了整个spu商品的几项信息
    //@Select("select * from productimg where productspuid=#{}")
    @Select("select * from product_spu where productid_spu=#{productspuid}")
//    @Results(id = "product_spu",value = {
//        @Result(column = "ProductID_spu",property = "ProductID_spu"),
//        @Result(column = "ProductName",property = "ProductName"),
//        @Result(column = "Classify",property = "Classify"),
//        @Result(column = "Status",property = "Status"),
//        @Result(column = "Price",property = "Price"),
//
//            })
    public product_spu findProduct_spuByProductSpuID(int productspuid);

    @Select("select ProductPhoto from product_spu where productid_spu=#{productspuid}")
    public String findProduct_ProductPhoto(int productspuid);

    //从spu表找出attr_key和attr_value
    @Select("select attr_key from product_spu where productid_spu=#{productspuid}")
    public String findSpu_attrkey(int productspuid);

    @Select("select attr_value from product_spu where productid_spu=#{productspuid}")
    public String findSpu_attrvalue(int productspuid);

    //尝试利用findSpu_attrkey得出的结果做参数利用${}来in出所有的key_name
    @Select("select key_name from attr_key where key_id in (${findSpu_attrkey})")
    public List<String> findAttrKey(@Param("findSpu_attrkey")String findSpu_attrkey);

//    使用#传入参数是，sql语句解析是会加上"",而${}传进什么就是什么,不过#{}能防止sql注入,SQL注入是发生在编译的过程中，因为恶意注入了某些特殊字符，最后被编译成了恶意的执行操作。而预编译机制则可以很好的防止SQL注入
    @Select("select value_name from attr_value where value_id in(${findSpu_attrvalue}) and key_id=#{findSpu_attrkey}")
    public List<String> findAttrValue(@Param("findSpu_attrvalue")String findSpu_attrvalue,@Param("findSpu_attrkey")String findSpu_attrkey);
//    @Select("select * from product_spu where ProductName=#{a}")
//    public int d2(String a);

//    利用value_id拿到value_name
    @Select("select value_name from attr_value where value_id in(${findSpu_attrvalue})")
    public List<String> findAttrValue2(@Param("findSpu_attrvalue")String findSpu_attrvalue);


    @Select("select value_id from attr_value where value_id in(${findSpu_attrvalue}) and key_id=#{findSpu_attrkey}")
    public List<String> findAttrValueid(@Param("findSpu_attrvalue")String findSpu_attrvalue, @Param("findSpu_attrkey")String findSpu_attrkey);

    @Select("select * from product_sku where description=#{description} and productspuid=#{productspuid} ")
    public product findProductByDesAndSpuid(String description,int productspuid);
//在sku表里找出商品所有的sku组合
    @Select("select attr_value from product_sku where ProductSpuID=#{productspuid}")
    public List<String> findSku_attrvalue(int productspuid);
    //找出sku商品的图片
    @Select("select ProductPhoto from productimg where desception=#{desception}")
    public String findSku_photo(String desception);

    //找出所有分类
    @Select("select Classify from classify")
    public List<String> findClassify();

    //按分类找商品
    @Select("select * from product_spu where Classify in (select ClassifyID from classify where Classify=#{classify})")
    public List<product_spu1> findProductByClassify1(String classify);

    //按购物车里找商品
    @Select("SELECT * from product_sku where ProductID in(select ProductID from shopcar where UserNum=#{userNum})")
    public List<product_sku> selectCarByUser(String userNum);
    @Select("select value_name from attr_value where value_id in(${findSpu_attrvalue})")//找规格值
    public List<String> selectAttrvalue(String findSpu_attrvalue);
    @Select("select ProductPhoto from productimg where desception in(${attrvalue})")//找sku的图片
    public String selectImgByAttrvalue(String attrvalue);
    @Select("select attr_value from product_sku where ProductID=#{productid}")
    public String findSku_attrvalueId(int productid);
    @Select("select * from shopcar where UserNum=#{userNum}")
    public List<shopCar> findCar(String userNum);

    //通过选择的sku规格与spuid找出sku商品id
    @Select("select value_id from attr_value where value_name in(${findSpu_attrvalue})")//找规格值
    public List<String> selectAttrvalueid(String findSpu_attrvalue);

    @Select("select ProductID from product_sku where ProductSpuID=#{productSpuId} and attr_value=#{attrValueId}")//利用规格值与spuid找出那个sku
    public int selectSkuProductIdBySpuidAndAttrvalueid(int productSpuId,String attrValueId);

    @Select("select * from product_sku where ProductID=#{productId}")//利用skuId找sku商品
    public product_sku1 findProductBySkuId(int productId);

    //按订单里找商品
    @Select("SELECT * from product_sku where ProductID in(select ProductID from ordere where UserNum=#{userNum})")
    public List<product_sku> selectOrderByUser(String userNum);

}
