package com.project.sports.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="tb_teacher")
public class Teacher implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name cannot be empty")
	@Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
	private String name;
	

	@ManyToOne
	private Institute institute;
	
	@OneToMany
	private Sport sport;
	
	public Teacher() {}

	public Teacher(Long id, String name, Institute institute) {
		super();
		this.id = id;
		this.name = name;
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


	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name  + ", institute=" + institute + "]";
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
		Teacher other = (Teacher) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
