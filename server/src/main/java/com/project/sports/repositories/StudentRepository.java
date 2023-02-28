package com.project.sports.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sports.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
