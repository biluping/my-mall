package com.mall.service;

import com.mall.domain.ao.StartPartUploadAO;
import com.mall.domain.vo.FileInfoVO;

public interface FileDetailService {

    FileInfoVO start(StartPartUploadAO ao);

    String mergePart(Long fileDetailId);
}