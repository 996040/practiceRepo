package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
