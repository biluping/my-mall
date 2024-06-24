package com.mall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品管理
 */
@Validated
@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {
}
