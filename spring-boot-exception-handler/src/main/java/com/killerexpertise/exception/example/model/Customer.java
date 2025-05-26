package com.killerexpertise.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String mobile;
    private String address;

    @Lob
    @Column(name = "aadhar_card", columnDefinition = "MEDIUMBLOB")
    private byte[] aadharCard;  // store file content as MEDIUMBLOB in DB
}
