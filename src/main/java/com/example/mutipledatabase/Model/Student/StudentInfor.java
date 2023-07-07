package com.example.mutipledatabase.Model.Student;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "student_infor")
@Data
public class StudentInfor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentID;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_class")
    private String studentClass;
    @Column(name = "student_manager")
    private String studentManager;

    
}
