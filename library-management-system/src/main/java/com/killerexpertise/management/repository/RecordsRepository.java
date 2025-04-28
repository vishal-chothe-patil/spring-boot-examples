package com.killerexpertise.management.repository;

import com.killerexpertise.management.model.Records;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RecordsRepository {

    private final Map<Integer, Records> recordsMap = new HashMap<>();

    public void save(Records record) {
        recordsMap.put(record.getRecordId(), record);
    }

    public Records findById(int id) {
        return recordsMap.get(id);
    }

    public List<Records> findAll() {
        return new ArrayList<>(recordsMap.values());
    }

    public void deleteById(int id) {
        recordsMap.remove(id);
    }

    public List<Records> findByUserName(String name) {
        List<Records> matchedRecords = new ArrayList<>();
        for (Records record : recordsMap.values()) {
            if (record.getUser().getName() != null && record.getUser().getName().equalsIgnoreCase(name)) {
                matchedRecords.add(record);
            }
        }
        return matchedRecords;
    }
}
