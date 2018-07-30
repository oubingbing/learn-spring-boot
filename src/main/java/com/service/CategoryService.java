package com.service;

import com.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    /**
     * 根据ID查找数据
     *
     * @param categoryId
     * @return
     */
    ProductCategory findByCategoryId(Integer categoryId);

    /**
     * 根据类型来查找数据
     *
     * @param categoryList
     * @return
     */
    List<ProductCategory> findByCategoryTypes(List<Integer> categoryList);

    /**
     * 获取所有分类信息
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 新增数据
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
