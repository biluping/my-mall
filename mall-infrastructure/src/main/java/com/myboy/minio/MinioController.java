package com.myboy.minio;

import lombok.RequiredArgsConstructor;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * minio 接口
 */
@RequiredArgsConstructor
@RestController
public class MinioController {

    private final FileStorageService fileStorageService;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public FileInfo upload(MultipartFile file) {
        return fileStorageService.of(file).upload();
    }
}
