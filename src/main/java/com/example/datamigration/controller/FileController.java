package com.example.datamigration.controller;

import com.example.datamigration.Utils.CSVReaderService;
import com.example.datamigration.Utils.MigrationData;
import com.example.datamigration.Utils.ProductItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/datamigration")
@RestController
public class FileController {

    @Autowired
    private CSVReaderService csvReaderService;


    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "success";
    }
     @PostMapping("/upload")
    public List<MigrationData> uploadCSV(@RequestParam("file1") MultipartFile file,@RequestParam("file2") MultipartFile file2,
                                         @RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4,
                                         @RequestParam("file5") MultipartFile file5,@RequestParam("file6") MultipartFile file6,
                                         @RequestParam("file7") MultipartFile file7,@RequestParam("file8") MultipartFile file8,
                                         @RequestParam("file9") MultipartFile file9) {

        List<MigrationData> migrationData = csvReaderService.readDataFromCSV(file,file2,file3,file4,file5,file6,file7,file8,file9);
        return csvReaderService.readDataFromCSV(file,file2,file3,file4,file5,file6,file7,file8,file9);
    }
}
