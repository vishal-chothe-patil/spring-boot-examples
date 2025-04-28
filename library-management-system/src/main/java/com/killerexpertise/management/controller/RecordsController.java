package com.killerexpertise.management.controller;

import com.killerexpertise.management.model.Records;
import com.killerexpertise.management.service.RecordsService;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@Setter
public class RecordsController {

    private static final Logger logger = LoggerFactory.getLogger(RecordsController.class);

    @Autowired
    private RecordsService recordsService;

    @PostMapping("/borrow")
    public String createBorrowRecord(@RequestBody Records record) {
        logger.info("Request received to borrow a book for user: {}", record.getUser().getName());
        recordsService.borrowBook(record);
        logger.info("Book borrowed successfully for user: {}", record.getUser().getName());
        return "Book borrowed successfully!";
    }

    @GetMapping("/get-all")
    public List<Records> getAllBorrowRecords() {
        logger.info("Request received to fetch all borrow records.");
        return recordsService.getAllRecords();
    }

    @GetMapping("/get/{recordId}")
    public Records getBorrowRecordById(@PathVariable int recordId) {
        logger.info("Request received to fetch borrow record with ID: {}", recordId);
        return recordsService.getRecord(recordId);
    }

    @PutMapping("/update/{recordId}")
    public String updateBorrowRecord(@PathVariable int recordId, @RequestBody Records record) {
        logger.info("Request received to update borrow record with ID: {}", recordId);
        record.setRecordId(recordId);
        recordsService.updateRecord(record);
        logger.info("Borrow record updated successfully for ID: {}", recordId);
        return "Borrow record updated successfully!";
    }

    @DeleteMapping("/delete/{recordId}")
    public String deleteBorrowRecord(@PathVariable int recordId) {
        logger.warn("Request received to delete borrow record with ID: {}", recordId);
        recordsService.deleteRecord(recordId);
        logger.info("Borrow record deleted successfully for ID: {}", recordId);
        return "Borrow record deleted successfully!";
    }

    @GetMapping("/search/by-user/{userName}")
    public List<Records> getBorrowRecordsByUser(@PathVariable String userName) {
        logger.info("Request received to fetch borrow records for user: {}", userName);
        return recordsService.getRecordsByUserName(userName);
    }
}
