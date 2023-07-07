package com.example.mutipledatabase.Repository.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mutipledatabase.Model.Student.StudentInfor;

public interface StudentInforRepository extends JpaRepository<StudentInfor, Integer> {
    
}
