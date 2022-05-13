package com.adu.learn.mybatis.service.impl;

import com.adu.learn.mybatis.entity.Product;
import com.adu.learn.mybatis.mapper.ProductMapper;
import com.adu.learn.mybatis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product add(Product product) {
        int i = productMapper.add(product);
        return product;
    }

    @Override
    public int delete(Integer id) {
        return productMapper.delete(id);
    }

    @Override
    public int update(Product product) {
        return productMapper.update(product);
    }

    @Override
    public List<Product> list() {
        return productMapper.list();
    }
}
