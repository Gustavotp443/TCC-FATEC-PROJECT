package com.project.sports.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.project.sports.entities.enums.Sports;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="tb_sport")
public class Sport implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@NotBlank(message="Sport name cannot be empty")
	private Sports name;
	
	@Valid
	@ManyToOne
	private Court court;
	
	@Valid
	@OneToOne
	private Teacher teacher;
	

	@Valid
	@ManyToMany(mappedBy="sports")
	private Set<Student> students = new HashSet<>();

	public Sport() {}
	
	


	public Sport(Long id, @NotBlank(message = "Sport name cannot be empty") Sports name) {
		super();
		this.id = id;
		this.name = name;

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sports getName() {
		return name;
	}

	public void setName(Sports name) {
		this.name = name;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		students.add(student);
	}




	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", court=" + court + ", teacher=" + teacher + ", students="
				+ students + "]";
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
		Sport other = (Sport) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
