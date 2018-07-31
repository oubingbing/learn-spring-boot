package com.sell.responseobject;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品的返回格式
 */
@Data
public class ResponseProduct {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ResponseProductInfo> productInfoList;
}
