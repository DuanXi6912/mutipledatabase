package com.example.mutipledatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mutipledatabase.Model.Person.PersonInfor;
import com.example.mutipledatabase.Model.Student.StudentInfor;
import com.example.mutipledatabase.Repository.Person.PersonInforRepository;
import com.example.mutipledatabase.Repository.Student.StudentInforRepository;

@SpringBootApplication
@ComponentScan("com.example.mutipledatabase.*")
@RestController
public class MutipledatabaseApplication {

	@Autowired
	private StudentInforRepository studentInforRepository;
	@Autowired
	private PersonInforRepository personInforRepository;

	@GetMapping("/students")
	public List<StudentInfor> getStudents(){
		return studentInforRepository.findAll();
	}

	@GetMapping("/persons")
	public List<PersonInfor> getPersons(){
		return personInforRepository.findAll();
	}
	public static void main(String[] args) {
		SpringApplication.run(MutipledatabaseApplication.class, args);
	}

}
