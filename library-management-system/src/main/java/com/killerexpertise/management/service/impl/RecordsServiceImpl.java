package com.killerexpertise.management.service.impl;

import com.killerexpertise.management.model.Records;
import com.killerexpertise.management.repository.RecordsRepository;
import com.killerexpertise.management.service.RecordsService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
public class RecordsServiceImpl implements RecordsService {

    @Autowired
    private RecordsRepository recordsRepository;

    @Override
    public void borrowBook(Records record) {
        recordsRepository.save(record);
    }

    @Override
    public Records getRecord(int id) {
        return recordsRepository.findById(id);
    }

    @Override
    public List<Records> getAllRecords() {
        return recordsRepository.findAll();
    }

    @Override
    public void updateRecord(Records record) {
        recordsRepository.save(record);
    }

    @Override
    public void deleteRecord(int id) {
        recordsRepository.deleteById(id);
    }

    @Override
    public List<Records> getRecordsByUserName(String userName) {
        return recordsRepository.findByUserName(userName);
    }
}
