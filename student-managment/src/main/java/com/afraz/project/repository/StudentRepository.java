package com.afraz.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afraz.project.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
