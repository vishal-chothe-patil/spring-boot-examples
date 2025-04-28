package com.killerexpertise.management.model;

import lombok.Data;

@Data
public class College {

    private String id; // could be "SIOM", "SIMCA", etc.
    private String name;
    private String address;
}