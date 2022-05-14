package com.adu.learn.mybatis.service;

import com.adu.learn.mybatis.common.CommonPage;
import com.adu.learn.mybatis.entity.Product;

import java.util.List;

public interface ProductService {
    Product add(Product product);

    int delete(Integer id);

    int update(Product product);

    List<Product> list();

    CommonPage<Product> page(Integer pageNo, Integer pageSize);
}
