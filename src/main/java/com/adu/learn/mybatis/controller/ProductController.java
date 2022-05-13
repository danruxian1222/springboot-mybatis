package com.adu.learn.mybatis.controller;

import com.adu.learn.mybatis.common.MybatisResult;
import com.adu.learn.mybatis.entity.Product;
import com.adu.learn.mybatis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("add")
    public MybatisResult<Product> add(@RequestBody Product product){
        product = productService.add(product);
        return MybatisResult.ok(product);
    }

    @PostMapping("delete/{id}")
    public MybatisResult delete(@PathVariable("id") Integer id){
        int i = productService.delete(id);
        return MybatisResult.ok();
    }

    @PostMapping("update")
    public MybatisResult update(@RequestBody Product product){
        int i = productService.update(product);
        return MybatisResult.ok();
    }

    @GetMapping("list")
    public MybatisResult list(){
        List<Product> products = productService.list();
        return MybatisResult.ok(products);
    }
}
