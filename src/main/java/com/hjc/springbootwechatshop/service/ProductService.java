package com.hjc.springbootwechatshop.service;

import com.hjc.springbootwechatshop.domain.product;
import com.hjc.springbootwechatshop.domain.product_sku1;
import com.hjc.springbootwechatshop.domain.product_spu;
import com.hjc.springbootwechatshop.domain.product_spu1;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<product_spu1> findAllProduct();
    public List<product_spu1> findAllHot();

    public List<product_spu1> findProductByClassify(String classify);

    public product findProductByProductSpuID(int productspuid);

    public product_spu findProduct_spuByProductSpuID(int productspuid);

    public List<product> findProductByProductSpuIDALL(int productspuid);

    public product findProductByDesAndSpuid(String description,int productspuid);

    //public List<String> findAttrKey(String findSpu_attrkey);
    public Map findSku_KeyValue(int productspuid);

    public List<String[]> findSku_attrvalue(int productspuid);

    public String findSku_photo(String desception);

    public List<String> findClassify();

    int selectSkuProductIdBySpuidAndAttrvalueid(int productSpuId,String attrValueId);

    product_sku1 findProductBySkuId(int productId);

}
