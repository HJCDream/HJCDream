package com.hjc.springbootwechatshop.service.impl;

import com.hjc.springbootwechatshop.dao.ProductMapper;
import com.hjc.springbootwechatshop.domain.product;
import com.hjc.springbootwechatshop.domain.product_sku1;
import com.hjc.springbootwechatshop.domain.product_spu;
import com.hjc.springbootwechatshop.domain.product_spu1;
import com.hjc.springbootwechatshop.service.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper product;

    @Override
    public List<product_spu1> findAllProduct() {
        List<product_spu1> productList=product.findAllProduct();

        return productList;
    }

    @Override
    public List<product_spu1> findAllHot() {
        List<product_spu1> productList=product.findAllHot();

        return productList;
    }

    @Override
    public List<product_spu1> findProductByClassify(String classify) {
        List<product_spu1> productByClassify = product.findProductByClassify(classify);
        return productByClassify;
    }

    @Override
    public product findProductByProductSpuID(int productspuid) {
        product productByProductSpuID = product.findProductByProductSpuID(productspuid);
        return productByProductSpuID;
    }

    //这里是把这个SPU商品的value组合全部罗列出来
    public List<String[]> findSku_attrvalue(int productspuid){
        List<String> sku_attrvalue = product.findSku_attrvalue(productspuid);
        List<String[]> sku_valueAll=new ArrayList<>();
        for(int i=0;i<sku_attrvalue.size();i++){
//            这里我把拿到的sku的valueID通过循环list把每组valueID置换成value再放进sku_valueALL里
            List<String> attrValue2 = product.findAttrValue2(sku_attrvalue.get(i));


            //String[] attrvalue=new String[sku_attrvalue.get(i).length()];
            String[] attrvalue=new String[attrValue2.size()];
            for(int j=0;j<attrValue2.size();j++) {
                attrvalue[j] = attrValue2.get(j);
            }
            //attrvalue=sku_attrvalue.get(i).split(",");//本来这里是直接把sku_attrvalue里面存的value_id直接放进attrvalue里的，现在改成把置换过的value_name放进去。
            sku_valueAll.add(attrvalue);

        }
        return sku_valueAll;

    }

    @Override
    public String findSku_photo(String desception) {
        String sku_photo = product.findSku_photo(desception);
        return sku_photo;
    }

    @Override
    public List<String> findClassify() {
        List<String> classify= product.findClassify();
        return classify;
    }

    @Override
    public int selectSkuProductIdBySpuidAndAttrvalueid(int productSpuId, String attrValueId) {
        System.out.println("attrValueId:"+attrValueId);
        String[] split = attrValueId.split(",");
        for(int i=0;i<split.length;i++){
            split[i]="\'"+split[i]+"\'";
        }
        String attrValue=String.join(",",split);
        List<String> attrvalueid = product.selectAttrvalueid(attrValue);
        String attrvalueid2=String.join(",",attrvalueid);
        return product.selectSkuProductIdBySpuidAndAttrvalueid(productSpuId,attrvalueid2);
    }

    @Override
    public product_sku1 findProductBySkuId(int productId) {
        product_sku1 sku1=product.findProductBySkuId(productId);
//        product_sku1 product_sku1 =

        String attr_value = product.findSku_attrvalueId(productId);
        List<String> attrvalue = product.selectAttrvalue(attr_value);

        String attrvalue2 = attrvalue.stream().map(s -> "\'" + s + "\'").collect(Collectors.joining(","));//把list里面的每个元素加上单引号并用逗号隔开
        //String.join(",", attrvalue);
        System.out.println("attrvalue2:"+attrvalue2);
        String img = product.selectImgByAttrvalue(attrvalue2);
        sku1.setAttr_value(attrvalue2);
        sku1.setImg(img);


        return sku1;
    }

//    @Override
//    public product_spu findProduct_spuByProductSpuID(int productspuid) {
//        product_spu product_spuByProductSpuID = product.findProduct_spuByProductSpuID(productspuid);
//
//        return product_spuByProductSpuID;
//    }


    @Override
    public product_spu findProduct_spuByProductSpuID(int productspuid) {
        //找到商品相关banner
        String photo = product.findProduct_ProductPhoto(productspuid);
        String[] productphoto=photo.split(",");

        //找到商品SKU的key
        String key=product.findSpu_attrkey(productspuid);
        String[] attr_keyid = key.split(",");
        String[] attr_key = product.findAttrKey(key).toArray(new String[0]);//把数组类型换成了集合类型
        //List<String> attr_key = product.findAttrKey(key);
        String value = product.findSpu_attrvalue(productspuid);
        String[] attr_valueid = value.split(",");//把商品的spu所有的sku Value放进数组里
        String[][] attr_value = new String[attr_valueid.length][];//创建一个二维数组，二维数组的每一行都会根据键的不同把值放在不同的行


        List<String> attr_value2;//这里单独给sku的值创个列表，只为用它当作HashMap的值，因此不需要上面那样为避免被后面循环的值覆盖而创出二维数组了
        HashMap<String,Object> key_value=new HashMap();
        for (int i=0;i<attr_keyid.length;i++){
            //for(int j=0;j<attr_keyid.length;j++) {
                attr_value[i]= product.findAttrValue(value, attr_keyid[i]).toArray(new String[0]);
            //}
            attr_value2= product.findAttrValue(value, attr_keyid[i]);
            key_value.put(attr_key[i],attr_value2);
        }
        product_spu product_spuByProductSpuID = product.findProduct_spuByProductSpuID(productspuid);
        product_spuByProductSpuID.setProductPhoto(productphoto);
        product_spuByProductSpuID.setAttr_key(attr_key);
        product_spuByProductSpuID.setAttr_value(attr_value);

        return product_spuByProductSpuID;
    }

    //在这里我把key和value单独分出来放进map里而不需要弄成二维数组那样难理解的逻辑了
    public Map findSku_KeyValue(int productspuid){
        //找到商品SKU的key
        String key=product.findSpu_attrkey(productspuid);
        String[] attr_keyid = key.split(",");

        String[] attr_key = product.findAttrKey(key).toArray(new String[0]);//把数组类型换成了集合类型
        //List<String> attr_key = product.findAttrKey(key);
        String value = product.findSpu_attrvalue(productspuid);
        List<String> attr_value2;//这里单独给sku的值创个列表，只为用它当作HashMap的值，因此不需要上面那样为避免被后面循环的值覆盖而创出二维数组了
        HashMap<String,Object> key_value=new HashMap();
        List<String> valueid;
        HashMap<String,String> valueid_value=new HashMap();
        for (int i=0;i<attr_keyid.length;i++){
            //for(int j=0;j<attr_keyid.length;j++) {

            //}
            valueid=product.findAttrValueid(value,attr_keyid[i]);
            attr_value2= product.findAttrValue(value, attr_keyid[i]);//根据给的value in出这个key拥有的所有值
            //准备在map的值里再嵌套一个map用作valueid:value
//            for(int j=i;j<attr_value2.size();j++){
//                valueid_value.put(valueid.get(j),attr_value2.get(j));
//            }
            key_value.put(attr_key[i],attr_value2);
        }
        return key_value;

    }

    @Override
    public List<product> findProductByProductSpuIDALL(int productspuid) {
        List<product> productByProductSpuIDALL = product.findProductByProductSpuIDALL(productspuid);
        return productByProductSpuIDALL;
    }

    @Override
    public com.hjc.springbootwechatshop.domain.product findProductByDesAndSpuid(String description, int productspuid) {
        return null;
    }



//
//    String key=product.findSpu_attrkey()
//    @Override
//    public List<String> findAttrKey(String findSpu_attrkey) {
//        return null;
//    }
}
