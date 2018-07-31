package com.sell.service.impl;

import com.sell.dataobject.ProductCategory;
import com.sell.repository.ProductCategoryRepository;
import com.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findByCategoryId(Integer categoryId) {
        return repository.findByCategoryId(categoryId);
    }

    @Override
    public List<ProductCategory> findByCategoryTypes(List<Integer> categoryList) {
        return repository.findByCategoryTypeIn(categoryList);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
