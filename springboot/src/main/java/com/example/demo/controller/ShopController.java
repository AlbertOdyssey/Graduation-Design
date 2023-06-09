package com.example.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.News;
import com.example.demo.entity.Shop;
import com.example.demo.mapper.NewsMapper;
import com.example.demo.mapper.ShopMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/shop")
public class ShopController extends BaseController {

  @Resource
  ShopMapper shopMapper;

  @PostMapping("/buy")
  public Result<?> buy(@RequestBody Shop shop) {
    Shop shopInfo = Shop.builder()
        .username(shop.getUsername())
        .good(shop.getGood())
        .time(new Date())
        .build();
    shopMapper.insert(shopInfo);
    return Result.success();
  }

  /*@PutMapping
  public Result<?> update(@RequestBody Shop shop) {
    shopMapper.updateById(shop);
    return Result.success();
  }*/

  /*@DeleteMapping("/{id}")
  public Result<?> update(@PathVariable Long id) {
    shopMapper.deleteById(id);
    return Result.success();
  }*/

  /*@GetMapping("/{id}")
  public Result<?> getById(@PathVariable Long id) {
    return Result.success(shopMapper.selectById(id));
  }

  @GetMapping
  public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            @RequestParam(defaultValue = "") String search) {
    LambdaQueryWrapper<News> wrapper = Wrappers.<News>lambdaQuery();
    if (StrUtil.isNotBlank(search)) {
      wrapper.like(News::getTitle, search);
    }*/
    /*Page<Shop> shopPage = shopMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    return Result.success(shopPage);
    /*Page<News> newsPage = newsMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
    return Result.success(newsPage);
    return Result.success();
  }*/
}