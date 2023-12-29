package com.example.importcsv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    @Id
    private String bank_identifier;

    private String name;

}
