package com.mall.controller;

import com.mall.domain.ao.StartPartUploadAO;
import com.mall.domain.vo.FileInfoVO;
import com.mall.service.FileDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class MinioController {

    private final FileDetailService fileDetailService;

    /**
     * 开始分片上传
     */
    @PostMapping("startPartUpload")
    public FileInfoVO startPartUpload(@RequestBody @Valid StartPartUploadAO ao) {
        return fileDetailService.start(ao);
    }

    /**
     * 合并分片
     */
    @GetMapping("/mergePart/{fileDetailId}")
    public String mergePart(@PathVariable Long fileDetailId) {
        return fileDetailService.mergePart(fileDetailId);
    }

}
