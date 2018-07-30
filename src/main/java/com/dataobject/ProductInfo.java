package com.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
@DynamicUpdate
public class ProductInfo {
    @Id
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品价格 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private  Integer productStock;

    /** 商品描述 */
    private String productDescription;

    /** 商品图片 */
    private String productIcon;

    /** 商品状态 */
    private Integer productStatus;

    /** 类目编号 */
    private Integer categoryType;
}
