package com.adu.learn.mybatis.controller;

import com.adu.learn.mybatis.common.CommonPage;
import com.adu.learn.mybatis.common.MybatisResult;
import com.adu.learn.mybatis.entity.Product;
import com.adu.learn.mybatis.service.ProductService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("新增")
    @PostMapping("add")
    public MybatisResult<Product> add(@RequestBody Product product){
        product = productService.add(product);
        return MybatisResult.ok(product);
    }

    @ApiOperation("删除")
    @PostMapping("delete/{id}")
    public MybatisResult delete(@PathVariable("id") Integer id){
        int i = productService.delete(id);
        return MybatisResult.ok();
    }

    @ApiOperation("修改")
    @PostMapping("update")
    public MybatisResult update(@RequestBody Product product){
        int i = productService.update(product);
        return MybatisResult.ok();
    }

    @ApiOperation("全量查询")
    @GetMapping("list")
    public MybatisResult list(){
        List<Product> products = productService.list();
        return MybatisResult.ok(products);
    }

    @ApiOperation("分页查询")
    @GetMapping("page")
    public MybatisResult page(@RequestParam("pageNo") Integer pageNo,
                              @RequestParam("pageSize") Integer pageSize){
        CommonPage<Product> page = productService.page(pageNo, pageSize);
        return MybatisResult.ok(page);
    }

    @ApiOperation("新增发生异常回滚事务")
    @PostMapping("addEx2Rollback")
    public MybatisResult<Product> addEx2Rollback(@RequestBody Product product){
        product = productService.addEx2Rollback(product);
        return MybatisResult.ok(product);
    }
}
