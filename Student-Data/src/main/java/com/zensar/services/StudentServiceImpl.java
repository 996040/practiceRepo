package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entities.Student;
import com.zensar.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(int studentid) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentid).get();
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void updateStudent(int studentid, Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(int studentid) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(studentid);
		
	}

}
