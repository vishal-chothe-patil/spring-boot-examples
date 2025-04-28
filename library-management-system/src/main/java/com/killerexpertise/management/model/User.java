package com.killerexpertise.management.model;

import lombok.Data;

@Data
public class User {

    private int uid;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private College college;
}
