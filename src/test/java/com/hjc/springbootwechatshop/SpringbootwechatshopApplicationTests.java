package com.hjc.springbootwechatshop;

import com.hjc.springbootwechatshop.dao.ProductMapper;
import com.hjc.springbootwechatshop.domain.product_spu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootwechatshopApplicationTests {
    @Autowired
    private ProductMapper productMapper;
//    @Test
//    public void diuniloumou() {
//        List<product_spu> diuniloumou = productMapper.diuniloumou();
//        for (product_spu product_spu : diuniloumou) {
//            System.out.println(product_spu);
//        }
//
//    }
//    @Test
//    public void d2(){
//        int i = productMapper.d2("[中式公筷]无上漆纯手工定制高端木筷子");
//        System.out.println("ProductID_spu="+i);
//    }
    @Test
    public void d3(){
        String product_spuByProductSpuID = productMapper.findProduct_ProductPhoto(1000);
        String productPhoto = product_spuByProductSpuID;
        String[] productPhotos = productPhoto.split(",");
        String p;
        for (int i=0;i<productPhotos.length;i++){
            String s = productPhotos[i].toString();
            System.out.println(s);
        }


    }
}
