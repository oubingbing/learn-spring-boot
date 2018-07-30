package com.service.impl;

import com.dataobject.ProductInfo;
import com.enums.ProductStatusEnum;
import com.repository.ProductInfoRepository;
import com.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    /**
     * 根据主键查找
     * @author yezi
     * @param productId
     * @return
     */
    @Override
    public ProductInfo findById(String productId) {
        ProductInfo productInfo = repository.findByProductId(productId);
        return productInfo;
    }

    /**
     * 新增数据
     * @param productInfo
     * @return
     */
    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public List<ProductInfo> findByStatus(Integer ProductStatus) {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Page<ProductInfo> productInfoList = repository.findAll(pageable);
        return  productInfoList;
    }
}
