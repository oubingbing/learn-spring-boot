package com.sell.dataobject.mapper;import com.sell.dataobject.ProductCategory;import lombok.extern.slf4j.Slf4j;import org.junit.Assert;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.context.junit4.SpringRunner;import java.util.HashMap;import java.util.List;import java.util.Map;import static org.junit.Assert.*;@RunWith(SpringRunner.class)@SpringBootTest@Slf4jpublic class ProductCategoryMapperTest {    @Autowired    private ProductCategoryMapper productCategoryMapper;    @Test    public void insertByMapper() {        Map<String ,Object> map = new HashMap<>();        map.put("category_name","谷歌眼镜");        map.put("category_type",110);        Integer result = productCategoryMapper.insertByMapper(map);        Assert.assertEquals((Integer) 1,result);    }    @Test    public void insertByObject() {        ProductCategory productCategory = new ProductCategory();        productCategory.setCategoryName("平板电脑");        productCategory.setCategoryType(101);        Integer result = productCategoryMapper.insertByObject(productCategory);        Assert.assertEquals((Integer)1,result);    }    @Test    public void findById() {        ProductCategory productCategory = productCategoryMapper.findById(1);        Assert.assertNotNull(productCategory);    }    @Test    public void findAll(){        List<ProductCategory> productCategoryList = productCategoryMapper.findAll();        Assert.assertNotEquals(0,productCategoryList.size());    }}