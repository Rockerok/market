package ru.gb.market.back.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileService {

    private final String baseDir;

    public FileService(@Value("${storage.path}") String baseDir) throws IOException {
        this.baseDir = baseDir;
        Path dir = Path.of(baseDir);
        if (!Files.exists(dir)) {
            Files.createDirectory(dir);
        }
    }

    public void save(String data, String fileName) throws IOException {
        Files.write(getFilePath(fileName), data.getBytes());
    }

    public Path getFilePath(String fileName) {
        return Path.of(baseDir).resolve(fileName);
    }

    public byte[] getFileData(String fileName) throws IOException {
        return Files.readAllBytes(getFilePath(fileName));
    }
}
