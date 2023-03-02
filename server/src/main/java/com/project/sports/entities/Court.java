package com.project.sports.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_court")
public class Court implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name cannot be empty")
	@Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="court")
	private Set<Sport> sports = new HashSet<>();
	
	@ManyToOne
	private Institute institute;
	
	public Court() {}

	public Court(Long id,
			@NotBlank(message = "Name cannot be empty") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String name, Institute institute) {
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
		return "Court [id=" + id + ", name=" + name + "]";
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
		Court other = (Court) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
