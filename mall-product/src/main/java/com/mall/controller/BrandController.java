package com.mall.controller;

import com.mall.domain.PageVO;
import com.mall.domain.ao.BrandAddAO;
import com.mall.domain.ao.BrandPageAO;
import com.mall.domain.vo.BrandVO;
import com.mall.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 商品品牌
 */
@Validated
@RequiredArgsConstructor
@RequestMapping("/brand")
@RestController
public class BrandController {

    private final BrandService brandService;

    /**
     * 添加修改
     */
    @PostMapping("/add")
    public Long addBrand(@Valid @RequestBody BrandAddAO ao) {
        return brandService.add(ao);
    }

    /**
     * id 查询
     */
    @GetMapping("/getById/{id}")
    public BrandVO getById(@PathVariable("id") Long id) {
        return brandService.getById(id);
    }

    /**
     * 删除品牌
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        brandService.delete(id);
    }

    /**
     * 分页查询
     */
    @PostMapping("/page")
    public PageVO<BrandVO> page(@RequestBody @Valid BrandPageAO pageAO) {
        return brandService.page(pageAO);
    }

}
