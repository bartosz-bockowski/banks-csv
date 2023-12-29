package com.example.importcsv.service;

import com.example.importcsv.domain.Bank;
import com.example.importcsv.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    public List<Bank> importBanksFromCsvFile(MultipartFile file) throws IOException {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

        List<Bank> csvData = new ArrayList<>();
        for (CSVRecord record : csvParser) {
            String id = record.get(0);
            String name = record.get(1);
            Bank bank = new Bank(id, name);
            csvData.add(save(bank));
        }

        return csvData;
    }

}
