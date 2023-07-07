package com.example.mutipledatabase.Model.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "person_infor")
@Data
public class PersonInfor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personID;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "person_email")
    private String personEmail;
    @Column(name = "person_phone")
    private String personPhone;
}
