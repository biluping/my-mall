package com.mall.domain.vo;

import com.mall.domain.entity.FileDetailDO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FileInfoVO {

    /**
     * 文件 url
     */
    private String downloadUrl;

    /**
     * 文件id
     */
    private Long fileDetailId;

    /**
     * 分片上传预签名url列表，如果文件已经上传完成，这里为空
     */
    private List<FilePartVO> filePartVOList;

    public static FileInfoVO emptyPart(FileDetailDO fileDetailDO) {
        FileInfoVO fileInfoVO = new FileInfoVO();
        fileInfoVO.fileDetailId = fileDetailDO.getId();
        fileInfoVO.filePartVOList = new ArrayList<>();
        fileInfoVO.downloadUrl = fileDetailDO.genDownloadUrl();
        return fileInfoVO;
    }

    public static FileInfoVO part(FileDetailDO fileDetailDO, List<FilePartVO> filePartVOList) {
        FileInfoVO fileInfoVO = emptyPart(fileDetailDO);
        fileInfoVO.filePartVOList = filePartVOList;
        return fileInfoVO;
    }
}
