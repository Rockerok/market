package ru.gb.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.model.FileSaveRequest;
import ru.gb.market.services.FileService;

import java.io.IOException;

@RestController
@RequestMapping("/export/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public Boolean saveString(@RequestBody FileSaveRequest request) {
        try {
            fileService.save(request.getText(), request.getName());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @GetMapping(value = "/export/{fileName}", produces = "application/octet-stream")
    public byte[] getFile(@PathVariable String fileName) {
        try {
            return fileService.getFileData(fileName);
        } catch (IOException e) {
            return new byte[] {};
        }
    }

}
