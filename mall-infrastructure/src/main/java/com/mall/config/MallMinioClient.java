package com.mall.config;

import com.mall.domain.entity.FileDetailDO;
import com.mall.exception.BizException;
import io.minio.CreateMultipartUploadResponse;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.ListPartsResponse;
import io.minio.MinioAsyncClient;
import io.minio.http.Method;
import io.minio.messages.Part;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MallMinioClient extends MinioAsyncClient {

    private final MinioProperties minioProperties;

    public MallMinioClient(MinioAsyncClient minioAsyncClient, MinioProperties minioProperties) {
        super(minioAsyncClient);
        this.minioProperties = minioProperties;
    }

    /**
     * 初始化分片上传，获取 uploadId
     */
    @SneakyThrows
    public String getUploadId(String objectName) {
        CreateMultipartUploadResponse response = super.createMultipartUploadAsync(minioProperties.getBucket(), null, objectName, null, null).get();
        return response.result().uploadId();
    }

    /**
     * 获取分片的预签名 url
     */
    @SneakyThrows
    public String getPartPreSignUploadUrl(FileDetailDO fileDetailDO, Map<String, String> map) {
//        Map<String, String> headers = Maps.newHashMap();
//        Optional<MediaType> mediaType = MediaTypeFactory.getMediaType(fileDetailDO.getFileName());
//        mediaType.ifPresent(type -> headers.put("Content-Type", type.toString()));

        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                .bucket(minioProperties.getBucket())
                .method(Method.PUT)
                .expiry(1, TimeUnit.HOURS)
                .object(fileDetailDO.minioFileName())
                .extraQueryParams(map)
                .build();
        return super.getPresignedObjectUrl(args);
    }

    /**
     * 查询已经上传好的分片
     */
    @SneakyThrows
    public List<Part> listParts(String objectName, String uploadId) {
        CompletableFuture<ListPartsResponse> future = super.listPartsAsync(minioProperties.getBucket(), null, objectName, null, 0, uploadId, null, null);
        return future.get().result().partList();
    }

    /**
     * 合并分片
     */
    @SneakyThrows
    public void completeMultipartUpload(String objectName, String uploadId) {
        super.listPartsAsync(minioProperties.getBucket(), null, objectName, null, 0, uploadId, null, null)
                .thenCompose(resp -> {
                    try {
                        Part[] partArray = resp.result().partList().toArray(new Part[0]);
                        return super.completeMultipartUploadAsync(minioProperties.getBucket(), null, objectName, uploadId, partArray, null, null);
                    } catch (Exception e) {
                        log.error("completeMultipartUploadAsync失败", e);
                        throw new BizException("completeMultipartUploadAsync失败");
                    }
                }).get();
    }
}
