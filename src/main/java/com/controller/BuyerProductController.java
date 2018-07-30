package com.controller;

import com.dataobject.ProductCategory;
import com.dataobject.ProductInfo;
import com.enums.ProductStatusEnum;
import com.responseUntils.ResponseResult;
import com.responseobject.Response;
import com.responseobject.ResponseProduct;
import com.responseobject.ResponseProductInfo;
import com.service.impl.CategoryServiceImpl;
import com.service.impl.ProductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/list")
    public Response list(){

        //查找商品
        List<ProductInfo> productInfoList = productInfoService.findByStatus(ProductStatusEnum.UP.getCode());

        //查找类目
        List<Integer> categoryTypes = new ArrayList<>();
        for (ProductInfo productInfo : productInfoList){
            //获取商品的类目列表
            categoryTypes.add(productInfo.getCategoryType());
        }
        //根据查出的商品类目再查找出类目的信息
        List<ProductCategory> categoryList = categoryService.findByCategoryTypes(categoryTypes);

        //拼装数据
        List<ResponseProduct> responseProductList = new ArrayList<>();
        for (ProductCategory category:categoryList){
            ResponseProduct responseProduct = new ResponseProduct();
            responseProduct.setCategoryName(category.getCategoryName());
            responseProduct.setCategoryType(category.getCategoryType());

            List<ResponseProductInfo> responseProductInfoList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                //如果商品类目跟类目列表一致，则将数据添加到列表中
                if(productInfo.getCategoryType().equals(category.getCategoryType())){
                    ResponseProductInfo responseProductInfo = new ResponseProductInfo();
                    responseProductInfo.setProductId(productInfo.getProductId());
                    responseProductInfo.setProductName(productInfo.getProductName());
                    responseProductInfo.setProductPrice(productInfo.getProductPrice());
                    responseProductInfo.setGetProductIcon(productInfo.getProductIcon());
                    responseProductInfo.setProductDescription(productInfo.getProductDescription());
                    responseProductInfoList.add(responseProductInfo);
                }
            }

            responseProduct.setProductInfoList(responseProductInfoList);

            responseProductList.add(responseProduct);
        }

        return ResponseResult.success(responseProductList);
    }

    @GetMapping("/test")
    public String index(){
        return "hello world";
    }
}
