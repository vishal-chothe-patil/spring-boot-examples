package com.killerexpertise.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventor {
    private int id;
    private String title;
    private String developBy;

}
