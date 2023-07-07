package com.example.mutipledatabase.Repository.Person;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mutipledatabase.Model.Person.PersonInfor;


public interface PersonInforRepository extends JpaRepository<PersonInfor, Integer>{
    
}
