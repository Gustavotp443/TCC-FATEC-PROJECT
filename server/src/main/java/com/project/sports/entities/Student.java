package com.project.sports.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.project.sports.entities.enums.StudentLevel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="tb_students_sports",
			joinColumns= @JoinColumn(name="student_id"),
			inverseJoinColumns = @JoinColumn(name="sport_id"))
	private Set<Sport> sports = new HashSet<>();

	
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




	public List<Sport> getSport() {
		List<Sport> list = new ArrayList<>();
		for (Sport sport : sports) {
			list.add(sport);
		}
		return list;
	}

	public void addSport(Sport sport) {
		sports.add(sport);
	}
	
	public void removeSport(Sport sport) {
		for (Sport item : sports) {
			if(sport.equals(item)) {
				sports.remove(item);
			}
		}
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
