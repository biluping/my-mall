package com.mall.controller;

import com.mall.domain.PageVO;
import com.mall.domain.ao.SupplierAddAO;
import com.mall.domain.ao.SupplierPageAO;
import com.mall.domain.vo.SupplierVO;
import com.mall.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 供货商
 */
@Validated
@RequiredArgsConstructor
@RequestMapping("/supplier")
@RestController
public class SupplierController {

    private final SupplierService supplierService;

    /**
     * 添加修改
     */
    @PostMapping("/add")
    public Long add(@Valid @RequestBody SupplierAddAO ao) {
        return supplierService.add(ao);
    }

    /**
     * id 查询
     */
    @GetMapping("/getById/{id}")
    public SupplierVO getById(@PathVariable("id") Long id) {
        return supplierService.getById(id);
    }

    /**
     * 删除品牌
     */
    @DeleteMapping("/delete/{id}")
    public Long delete(@PathVariable("id") Long id) {
        return supplierService.delete(id);
    }

    /**
     * 分页查询
     */
    @PostMapping("/page")
    public PageVO<SupplierVO> page(@RequestBody @Valid SupplierPageAO pageAO) {
        return supplierService.page(pageAO);
    }

}
