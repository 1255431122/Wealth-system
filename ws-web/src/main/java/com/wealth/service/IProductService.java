package com.wealth.service;

import com.wealth.pojo.ProductPojo;

import java.util.List;

public interface IProductService {

    List<ProductPojo> getProducts(ProductPojo productPojo);
}
