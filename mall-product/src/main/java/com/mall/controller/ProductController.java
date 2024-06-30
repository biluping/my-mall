package com.mall.controller;

import com.mall.domain.ao.ProductAddAO;
import com.mall.service.SpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 商品管理
 */
@Validated
@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

    private final SpuService spuService;

    /**
     * 添加/更新商品
     */
    public Long add(@RequestBody @Valid ProductAddAO ao) {
        return spuService.add(ao);
    }
}
