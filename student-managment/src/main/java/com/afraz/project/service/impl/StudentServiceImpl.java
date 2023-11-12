package com.afraz.project.service.impl;

import java.util.List; 

import org.springframework.stereotype.Service;

import com.afraz.project.entity.Student;
import com.afraz.project.repository.StudentRepository;
import com.afraz.project.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
//when spring bean(here:StudentServiceImpl) has only one constructor we can avoid @Autowired annotation 
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	// For display all student 
	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	//add 
	@Override
	public Student saveStudent(Student student) {

		return studentRepository.save(student);
	}
	
	//get by id
	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).get();
	}

	//update
	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}

	///delete
	@Override
	public void deleteStudentById(Long id) {
		
		studentRepository.deleteById(id);
	}

}
