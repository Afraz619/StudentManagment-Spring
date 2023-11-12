package com.afraz.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.afraz.project.entity.Student;
import com.afraz.project.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//handler method to handle list student and return model and view
	
	@GetMapping("/students")
	public String listStudent(Model model) {
		 model.addAttribute("students", studentService.getAllStudents()); 						//addAttribute("attribute name",attribute value)
		 return "students";   											 						// returning view :-->created in templates
	} 
		 
																								
	
	//method to get data form browser
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
																							//**create student object to hold student Form data coming from browser 
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	//method to add student
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
																							//@ModelAttribute to bind the Form data directly to the object (ie:student)
		studentService.saveStudent(student);
		return "redirect:/students";
																							//it will redirect to display Student list page
	}
		 
	//get student data By ID
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
	}
	
	
	//update 
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id ,@ModelAttribute("student") Student student, Model model) {
		
		//get student from database by id
		Student existingStudent=studentService.getStudentById(id);
		
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setAddress(student.getAddress());
		
		//save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
		
		
	}
	
	//delete
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
