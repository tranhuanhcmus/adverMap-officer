package com.adsmanagement.files;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/files")
public class FileController {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/static";

    @PostMapping("")
    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        long unixTimestamp = Instant.now().getEpochSecond();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename() + "-" + unixTimestamp);
        Files.write(fileNameAndPath, file.getBytes());
        return "/uploads" + fileNameAndPath.toString();
    }
}