package com.sell.repository;

import com.sell.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    @Transactional
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("0001");
        productInfo.setProductName("小米5");
        productInfo.setProductPrice(new BigDecimal(3000));
        productInfo.setProductStock(1000);
        productInfo.setProductDescription("为发烧而生");
        productInfo.setProductIcon("https://img1.mukewang.com/54586313000139c902200220-140-140.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductIdTest(){
        log.info("测试UUID: " + UUID.randomUUID().toString());
        ProductInfo productInfo = repository.findByProductId("0002");
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findByProductStatusTest() {
        List<ProductInfo> productInfo = repository.findByProductStatus(0);
        Assert.assertNotNull(productInfo);
    }
}