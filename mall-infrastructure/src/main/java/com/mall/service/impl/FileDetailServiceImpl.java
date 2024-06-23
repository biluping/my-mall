package com.mall.service.impl;

import com.mall.config.MallMinioClient;
import com.mall.domain.ao.StartPartUploadAO;
import com.mall.domain.entity.FileDetailDO;
import com.mall.domain.vo.FileInfoVO;
import com.mall.domain.vo.FilePartVO;
import com.mall.mapper.FileDetailMapper;
import com.mall.service.FileDetailService;
import io.minio.messages.Part;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FileDetailServiceImpl implements FileDetailService {

    private final FileDetailMapper fileDetailMapper;
    private final MallMinioClient minioClient;

    @Override
    public FileInfoVO start(StartPartUploadAO ao) {
        FileDetailDO fileDetailDO = fileDetailMapper.findByNameMd5(ao.getFileName(), ao.getMd5());

        // 文件秒传
        if (fileDetailDO != null && fileDetailDO.getIsFinishUpload()) {
            return FileInfoVO.emptyPart(fileDetailDO);
        }

        List<FilePartVO> unUploadPartVOList = new ArrayList<>();
        Map<String, String> paramsMap = new HashMap<>();
        Set<Integer> existsPartNumberSet = new HashSet<>();
        Optional.ofNullable(fileDetailDO).ifPresent(it -> paramsMap.put("uploadId", it.getUploadId()));

        if (fileDetailDO == null) {
            // 第一次上传，保持数据，初始化 uploadId
            String uploadId = minioClient.getUploadId(ao.getFileName());
            fileDetailDO = ao.toDO(uploadId);
            fileDetailDO.insert();
            paramsMap.put("uploadId", uploadId);
        } else {
            // 断点续传，查处已经上传完成的分片
            existsPartNumberSet = minioClient.listParts(fileDetailDO.getFileName(), fileDetailDO.getUploadId()).stream().map(Part::partNumber).collect(Collectors.toSet());
        }

        // 返回要上传的分片对应预签名url
        for (int partNum = 1; partNum <= ao.getPartNum(); partNum++) {
            if (existsPartNumberSet.contains(partNum)) {
                continue;
            }
            paramsMap.put("partNumber", String.valueOf(partNum));
            String url = minioClient.getPartPreSignUploadUrl(fileDetailDO, paramsMap);
            unUploadPartVOList.add(new FilePartVO(partNum, url));
        }

        return FileInfoVO.part(fileDetailDO, unUploadPartVOList);
    }

    @Override
    public String mergePart(Long fileDetailId) {
        FileDetailDO fileDetailDO = fileDetailMapper.selectById(fileDetailId);
        minioClient.completeMultipartUpload(fileDetailDO.getFileName(), fileDetailDO.getUploadId());

        // 更新状态
        fileDetailDO.setIsFinishUpload(true);
        fileDetailDO.updateById();

        return fileDetailDO.genDownloadUrl();
    }
}