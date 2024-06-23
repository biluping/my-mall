package com.mall.config;

import io.minio.MinioAsyncClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(MinioProperties.class)
@Configuration
public class MinioConfig {

    @Bean
    public MallMinioClient minioClient(MinioProperties minioProperties) {
        MinioAsyncClient minioAsyncClient = MinioAsyncClient.builder()
                .endpoint(minioProperties.getEndpoint())
                .credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey())
                .build();
        return new MallMinioClient(minioAsyncClient, minioProperties);
    }
}
