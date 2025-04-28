package com.killerexpertise.management.model;

import lombok.Data;

@Data
public class Records {

    private int recordId;
    private User user;
    private Book book;

    private String borrowDate;
    private String returnDate;
    private boolean isReturned;
}
