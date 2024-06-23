package com.mall.domain.ao;

import com.mall.domain.entity.FileDetailDO;
import lombok.Data;

@Data
public class StartPartUploadAO {

    private String fileName;
    private String md5;
    private Integer partNum;

    public FileDetailDO toDO() {
        FileDetailDO fileDetailDO = new FileDetailDO();
        fileDetailDO.setFileName(fileName);
        fileDetailDO.setFileMd5(md5);
        fileDetailDO.setPartNum(partNum);
        return fileDetailDO;
    }
}
