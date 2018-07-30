package com.service;

import com.dataTransferObject.CartDTO;
import com.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductInfoService {
    /**
     * 根据主键查找商品
     * @param productId
     * @return
     */
    ProductInfo findById(String productId);

    /**
     * 新增数据
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 分页获取数据
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 根据商品状态查找商品
     * @param ProductStatus
     * @return
     */
    List<ProductInfo> findByStatus(Integer ProductStatus);

    /**
     * 增加库存
     * @param cartDTOS
     */
    void increaseStock(List<CartDTO> cartDTOS);

    /**
     * 减少库存
     * @param cartDTOS
     */
    void decreaseStock(List<CartDTO> cartDTOS);
}
