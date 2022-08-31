package com.hjc.springbootwechatshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.hjc.springbootwechatshop.domain.product;
import com.hjc.springbootwechatshop.domain.product_sku1;
import com.hjc.springbootwechatshop.domain.product_spu;
import com.hjc.springbootwechatshop.domain.product_spu1;
import com.hjc.springbootwechatshop.service.ProductService;
import com.hjc.springbootwechatshop.service.impl.ProductServiceImpl;
import com.hjc.springbootwechatshop.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @RequestMapping("/findAllProduct")
    public JSONResult productService(){
        List<product_spu1> productList=productService.findAllProduct();
        System.out.println(productList);
        return JSONResult.ok(productList);
    }
    @RequestMapping("/findAllHot")
    public JSONResult productHot(){
        List<product_spu1> productList=productService.findAllHot();
        System.out.println(productList);
        return JSONResult.ok(productList);
    }
    @RequestMapping("/findProductByProductSpuID/{productspuid}")
    //通过@PathVariable，例如/blogs/1
    //通过@RequestParam，例如blogs?blogId=1
    public JSONResult productsku(@PathVariable int productspuid){//@PathVariable指的是路径里的参数,这样@RequestMapping里的("/findProductByProductSpuID/{productspuid}")就能根据那物品的id做跳转了
        product productByProductSpuID = productService.findProductByProductSpuID(productspuid);
        return JSONResult.ok(productByProductSpuID);
    }

    @RequestMapping("/findProductByProductSpuIDALL/{productspuid}")
    public JSONResult prodcutskuall(@PathVariable int productspuid){
        List<product> productByProductSpuIDALL = productService.findProductByProductSpuIDALL(productspuid);
        return JSONResult.ok(productByProductSpuIDALL);
    }

    @RequestMapping("/findProduct_spuByProductSpuID/{productspuid}")
    public JSONResult productspu(@PathVariable int productspuid){
        product_spu product_spuByProductSpuID = productService.findProduct_spuByProductSpuID(productspuid);
        //String[] productPhoto = product_spuByProductSpuID.getProductPhoto();
        //String[] productPhotos = productPhoto.split(",");
        //看看是否有逗号，是否是多个图片
//        if (productPhoto.indexOf(",")<0){
//            product_spuByProductSpuID.setProductPhoto(productPhoto);
//        }else{
//            productPhotos=
//        }

//        for (int i=0;i<productPhotos.length;i++){
//            String s = productPhotos[i].toString();
//            //System.out.println(s);
//
//        }
        return JSONResult.ok(product_spuByProductSpuID);
    }

    @RequestMapping("/fidnProduct_skuByDescription")
    public JSONResult productsku(HttpServletRequest request, HttpServletResponse response){
        String description=request.getParameter("description");
        int skuid= Integer.parseInt(request.getParameter("skuid"));
        product productByDesAndSpuid = productService.findProductByDesAndSpuid(description, skuid);
        return JSONResult.ok(productByDesAndSpuid);
    }

    //单独把SKU商品的key和value取出放进Map里供前端使用
    @RequestMapping("/findSku_KeyValue/{productspuid}")
    public JSONResult findSku(@PathVariable int productspuid){
        Map sku_keyValue = productService.findSku_KeyValue(productspuid);
        for (Object o : sku_keyValue.keySet()) {
            System.out.println("key:"+o+"value:"+sku_keyValue.get(o));

        }
        return JSONResult.ok(sku_keyValue);

    }

    @RequestMapping("/findSku_attrvalue/{productspuid}")
    public List<String[]> findSku_attrvalue(@PathVariable int productspuid){
        List<String[]> sku_attrvalue = productService.findSku_attrvalue(productspuid);
        for (int i = 0; i <sku_attrvalue.size() ; i++) {
            for (int j = 0; j <sku_attrvalue.get(i).length ; j++) {
                System.out.println(sku_attrvalue.get(i)[j]);
            }
            System.out.println(sku_attrvalue.get(i));
        }

        return sku_attrvalue;
    }

    @RequestMapping("/findSku_photo/{desception}")
    public String findSku_photo(@PathVariable String desception){
        String sku_photo = productService.findSku_photo(desception);
        return sku_photo;

    }
    //返回所有分类
    @RequestMapping("/findClassify")
    public List<String> findClassify(){
        return productService.findClassify();
    }
    //按分类获得商品
    @RequestMapping("/findProductByClassify/{classify}")
    public List<product_spu1> findProductByClassify(@PathVariable String classify){
        return productService.findProductByClassify(classify);
    }

    @RequestMapping("/selectSkuProductId")
    public int selectSkuProductId(@RequestBody JSONObject SpuIdAndAtrr){
        int productspuid=SpuIdAndAtrr.getInteger("productspuid");
        String skuValue=SpuIdAndAtrr.getString("skuValue");
        return productService.selectSkuProductIdBySpuidAndAttrvalueid(productspuid,skuValue);
    }

    @RequestMapping("/selectSku")
    public product_sku1 selectSku(@RequestBody JSONObject skuid){
        int productId=skuid.getInteger("productId");
        return productService.findProductBySkuId(productId);
    }


}