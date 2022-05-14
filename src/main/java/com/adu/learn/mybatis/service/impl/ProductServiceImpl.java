package com.adu.learn.mybatis.service.impl;

import com.adu.learn.mybatis.common.CommonPage;
import com.adu.learn.mybatis.entity.Product;
import com.adu.learn.mybatis.mapper.ProductMapper;
import com.adu.learn.mybatis.service.ProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public CommonPage<Product> page(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Product> productList = productMapper.page();
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        CommonPage<Product> commonPage = new CommonPage(pageInfo);
        return commonPage;
    }

    @Transactional
    @Override
    public Product addEx2Rollback(Product product) {
        int i = productMapper.add(product);
        int j = i/0;
        return product;
    }
}
