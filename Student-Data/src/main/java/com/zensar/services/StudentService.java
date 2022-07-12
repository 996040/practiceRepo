package com.zensar.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.entities.Student;

public interface StudentService {
	
	public Student getStudent( int studentid);
	
	public List<Student> getAllStudent();
	
	public Student insertStudent(Student student);
	
	public void updateStudent( int studentid, Student student);
	
	public void deleteStudent(int studentid);

}
