package com.example.importcsv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Bank {

    @Id
    private String bank_identifier;

    private String name;

}
