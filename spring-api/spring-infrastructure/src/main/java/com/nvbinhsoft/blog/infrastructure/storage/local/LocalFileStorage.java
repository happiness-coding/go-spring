package com.nvbinhsoft.blog.infrastructure.storage.local;

import com.nvbinhsoft.blog.infrastructure.storage.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class LocalFileStorage implements FileStorageService {

    @Value("${file.storage.location}")
    private String storageLocation;

    @Override
    public void storeFile(String fileName, InputStream fileContent) {
        try {
            Path filePath = getFilePath(fileName);
            Files.copy(fileContent, filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    @Override
    public InputStream loadFile(String fileName) {
        try {
            Path filePath = getFilePath(fileName);
            return Files.newInputStream(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load file", e);
        }
    }

    @Override
    public void deleteFile(String fileName) {
        try {
            Path filePath = getFilePath(fileName);
            Files.delete(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete file", e);
        }
    }

    @Override
    public Path getFilePath(String fileName) {
        return Paths.get(storageLocation).resolve(fileName);
    }
}
