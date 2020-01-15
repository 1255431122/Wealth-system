package com.wealth.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wealth.pojo.ProductPojo;
import com.wealth.repository.ProductRepository;
import com.wealth.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@org.springframework.stereotype.Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductPojo> getProducts(ProductPojo productPojo) {
        return productRepository.findAll();
    }
}
