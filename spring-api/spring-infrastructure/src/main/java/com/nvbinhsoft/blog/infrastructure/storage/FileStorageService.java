package com.nvbinhsoft.blog.infrastructure.storage;

import java.io.InputStream;
import java.nio.file.Path;

public interface FileStorageService {

  void storeFile(String fileName, InputStream fileContent);

  InputStream loadFile(String fileName);

  void deleteFile(String fileName);

  Path getFilePath(String fileName);
}
