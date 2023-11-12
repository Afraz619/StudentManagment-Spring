package com.afraz.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.afraz.project.repository.StudentRepository;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.afraz.project.controller"})
public class StudentManagmentApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagmentApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception{
		
	}

}
