package com.adu.learn.mybatis.mapper;

import com.adu.learn.mybatis.entity.Product;

import java.util.List;

public interface ProductMapper {
    int add(Product product);

    int delete(Integer id);

    int update(Product product);

    List<Product> list();

    List<Product> page();
}
