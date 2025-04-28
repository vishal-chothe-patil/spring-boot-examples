package com.killerexpertise.management.service;


import com.killerexpertise.management.model.Records;

import java.util.List;

public interface RecordsService {

    void borrowBook(Records record);

    Records getRecord(int id);

    List<Records> getAllRecords();

    void updateRecord(Records record);

    void deleteRecord(int id);

    List<Records> getRecordsByUserName(String userName);
}
