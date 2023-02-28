package com.project.sports.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.project.sports.entities.enums.StudentLevel;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name cannot be empty")
	@Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
	private String name;
	
	@NotBlank(message="Level cannot be empty")
	@Enumerated(EnumType.STRING)
	private StudentLevel level;
	
	@NotBlank(message="Classroom cannot be empty")
	private String classroom;
	
	@ManyToOne
	@NotBlank(message="Institute cannot be empty")
	private Institute institute;

	
	public Student() {}
	
	
	
	
	public Student(Long id, String name, StudentLevel level, String classroom, Institute institute) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.classroom = classroom;
		this.institute = institute;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentLevel getLevel() {
		return level;
	}

	public void setLevel(StudentLevel level) {
		this.level = level;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", level=" + level + ", classroom=" + classroom + ", institute="
				+ institute + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}



	
}
