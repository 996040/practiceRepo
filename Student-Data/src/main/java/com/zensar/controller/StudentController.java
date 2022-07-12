package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entities.Student;
import com.zensar.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentid) {
		return studentService.getStudent(studentid);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@PostMapping("/students")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
	
	@PutMapping("/students/{studentId}")
	public void updateStudent(@PathVariable("studentId") int studentid,@RequestBody Student student) {
		studentService.updateStudent(studentid, student);
	}
	
	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable("studentId") int studentid) {
		studentService.deleteStudent(studentid);
	}
	
	
	
	
	
	

}
