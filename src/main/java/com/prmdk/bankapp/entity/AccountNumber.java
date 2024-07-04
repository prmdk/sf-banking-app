package com.prmdk.bankapp.entity;

import javax.persistence.*;

@Entity
@Table
public class AccountNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
