package com.project.sports.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_institute")
public class Institute extends User{
	private static final long serialVersionUID = 1L;

	@NotBlank(message="Name cannot be empty")
	@Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
	private String name;
	
	@OneToMany
	private Set<Student> students = new HashSet<>();
	
	@OneToMany
	private Set<Teacher> teachers = new HashSet<>();
	
	@Embedded
	@Valid
	private Endereco endereco;

	public Institute() {}

	public Institute(Long id, String email, String password, String name, Endereco endereco) {
		super(id, email, password);
		this.name = name;
		this.endereco = endereco;
	}

	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Student> getStudent() {
		List<Student> list = new ArrayList<>();
		for (Student student : students) {
			list.add(student);
		}
		return list;
	}

	public void addStudent(Student student) {
		students.add(student);
	}
	
	public void removeStudent(Student person) {
		for (Student student : students) {
			if(student.equals(person)) {
				students.remove(student);
			}
		}
	}

	public List<Teacher> getTeacher() {
		List<Teacher> list = new ArrayList<>();
		for (Teacher teacher : teachers) {
			list.add(teacher);
		}
		return list;
	}

	
	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}
	
	public void removeTeacher(Teacher person) {
		for (Teacher teacher : teachers) {
			if(teacher.equals(person)) {
				teachers.remove(teacher);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Institute [name=" + name + ", student=" + students + ", teacher=" + teachers + ", endereco=" + endereco
				+ "]";
	}
	
}
