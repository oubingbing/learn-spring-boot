package com.service.impl;

import com.dataTransferObject.CartDTO;
import com.dataobject.ProductInfo;
import com.enums.ProductStatusEnum;
import com.enums.ResponseEnum;
import com.exception.SellException;
import com.repository.ProductInfoRepository;
import com.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 扣减库存
     * @param cartDTOS
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO:cartDTOS){
            ProductInfo productInfo = repository.findByProductId(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResponseEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new SellException(ResponseEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    /**
     * 增加库存
     * @param cartDTOS
     */
    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO:cartDTOS){
            ProductInfo productInfo = repository.findByProductId(cartDTO.getProductId());
            if(productInfo == null){
                throw new SellException(ResponseEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = cartDTO.getProductQuantity() + productInfo.getProductStock();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Page<ProductInfo> productInfoList = repository.findAll(pageable);
        return  productInfoList;
    }
}
