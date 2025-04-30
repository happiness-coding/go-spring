package com.nvbinhsoft.blog.infrastructure.storage.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.nvbinhsoft.blog.infrastructure.storage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class S3FileStorage implements FileStorageService {

    private final AmazonS3 amazonS3;
    private final String bucketName;

    @Autowired
    public S3FileStorage(AmazonS3 amazonS3, @Value("${aws.s3.bucket-name}") String bucketName) {
        this.amazonS3 = amazonS3;
        this.bucketName = bucketName;
    }

    @Override
    public void storeFile(String fileName, InputStream fileContent) {
        ObjectMetadata metadata = new ObjectMetadata();
        PutObjectRequest request = new PutObjectRequest(bucketName, fileName, fileContent, metadata)
                .withCannedAcl(CannedAccessControlList.Private);
        amazonS3.putObject(request);
    }

    @Override
    public InputStream loadFile(String fileName) {
        S3Object s3Object = amazonS3.getObject(bucketName, fileName);
        return s3Object.getObjectContent();
    }

    @Override
    public void deleteFile(String fileName) {
        amazonS3.deleteObject(bucketName, fileName);
    }

    @Override
    public Path getFilePath(String fileName) {
        return Paths.get(bucketName, fileName);
    }
}
