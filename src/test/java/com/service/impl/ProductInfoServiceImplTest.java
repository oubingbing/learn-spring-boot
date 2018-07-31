package com.service.impl;

import com.sell.dataobject.ProductInfo;
import com.sell.enums.ProductStatusEnum;
import com.sell.service.impl.ProductInfoServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {
    @Autowired
    private ProductInfoServiceImpl service;

    @Test
    public void findById() {
        ProductInfo productInfo = service.findById("0002");
        Assert.assertNotNull(productInfo);
    }

    @Test
    @Transactional
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("0003");
        productInfo.setProductName("mac 2018");
        productInfo.setProductPrice(new BigDecimal(3000));
        productInfo.setProductStock(1000);
        productInfo.setProductDescription("为程序员而生");
        productInfo.setProductIcon("https://img1.mukewang.com/54586313000139c902200220-140-140.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = service.save(productInfo);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByStatus() {
        List<ProductInfo> list = service.findByStatus(ProductStatusEnum.UP.getCode());
        Assert.assertNotNull(list);
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,5);
        Page<ProductInfo> productInfoList = service.findAll(request);
        Assert.assertNotNull(productInfoList);
    }

}