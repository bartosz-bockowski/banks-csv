package com.example.importcsv.controller;

import com.example.importcsv.domain.Bank;
import com.example.importcsv.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bank")
public class BankController {

    private final BankService bankService;

    @PostMapping("/importCsv")
    public ResponseEntity<List<Bank>> importCsv(@RequestBody MultipartFile file) throws IOException {
        return new ResponseEntity<>(bankService.importBanksFromCsvFile(file), HttpStatus.OK);
    }

}
