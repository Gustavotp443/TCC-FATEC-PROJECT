package com.project.sports.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.project.sports.entities.enums.Sport;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
@Table(name="tb_teacher")
public class Teacher implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name cannot be empty")
	@Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
	private String name;
	
	
	@ElementCollection(targetClass=Sport.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="tb_sports")
	@Column(name="sports")
	Collection<Sport> sports;
	

	@ManyToOne
	@NotBlank(message="Institute cannot be empty")
	private Institute institute;
	
	public Teacher() {}

	public Teacher(Long id, String name, Sport sport, Institute institute) {
		super();
		this.id = id;
		this.name = name;
		this.institute = institute;
		
		for (Sport item : this.sports) {
			if(sport == item) {
				return;
			}
		}
		this.sports.add(sport);
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

	public List<Sport> getSports() {
		List<Sport> list = new ArrayList<>();
		for (Sport sport : sports) {
			list.add(sport);
		}
		return list;
	}

	public void addSports(Sport sport) {
		for (Sport item : sports) {
			if(item==sport) {
				return;
			}
		}
		sports.add(sport);
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", sports=" + sports + ", institute=" + institute + "]";
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
