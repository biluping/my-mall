package com.mall.controller;

import com.mall.domain.ao.CategoryAddAO;
import com.mall.domain.vo.CategoryVO;
import com.mall.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 商品分类
 */
@Validated
@RequiredArgsConstructor
@RequestMapping("/category")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * 添加修改分类
     */
    @PostMapping("/add")
    public void addCategory(@Valid @RequestBody CategoryAddAO ao) {
        categoryService.add(ao);
    }

    /**
     * id 查询分类
     */
    @GetMapping("/getById/{id}")
    public CategoryVO getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getById(id);
    }

    /**
     * 查询分类树
     */
    @GetMapping("/tree")
    public List<CategoryVO> getCategoryTree() {
        return categoryService.getCategoryTree();
    }

}
