package com.repository;

import com.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    ProductCategory findByCategoryId(Integer id);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
