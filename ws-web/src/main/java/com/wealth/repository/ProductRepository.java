package com.wealth.repository;

import com.wealth.pojo.ProductPojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductPojo, Integer> {
}
