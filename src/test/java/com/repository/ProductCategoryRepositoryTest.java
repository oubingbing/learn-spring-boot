package com.repository;

import com.sell.dataobject.ProductCategory;
import com.sell.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    @Transactional
    public void save() throws Exception{
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("平板");
        productCategory.setCategoryType(3);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryId() throws Exception {
        ProductCategory result = repository.findByCategoryId(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> list = Arrays.asList(1,2,3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }

}