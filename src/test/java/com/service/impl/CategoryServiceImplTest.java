package com.sell.service.impl;

import com.sell.dataobject.ProductCategory;
import com.sell.service.CategoryService;
import com.sell.service.impl.CategoryServiceImpl;
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
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService service;

    @Test
    public void findByCategoryId() throws Exception {
        ProductCategory productCategory = service.findByCategoryId(1);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findByCategoryTypes() throws Exception {
        List<Integer> types = Arrays.asList(1,2,3);
        List<ProductCategory> productCategoryList = service.findByCategoryTypes(types);
        Assert.assertNotNull(productCategoryList);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> result = service.findAll();
        Assert.assertNotNull(result);
    }

    @Test
    @Transactional
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("平板");
        productCategory.setCategoryType(4);
        ProductCategory result = service.save(productCategory);
        Assert.assertNotNull(result);
    }

}