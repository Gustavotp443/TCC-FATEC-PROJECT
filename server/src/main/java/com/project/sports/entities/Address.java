package com.project.sports.entities;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Embeddable
public class Address {
	
	@NotBlank(message="Name cannot be empty")
	@Size(min=3,max=50,message = "Name must be between 3 and 50 characters")
	private String street;
	
	@NotNull(message="Number cannot be null")
	private Integer number;
	
	@NotBlank(message="Cep cannot be empty")
	@Pattern(regexp="/^[0-9]{5}-[0-9]{3}$/")
	private String cep;
	
	@NotBlank(message="District cannot be empty")
	@Size(min=3,max=50,message = "District must be between 3 and 50 characters")
	private String district;
	
	@NotBlank(message="District cannot be empty")
	@Size(min=3,max=50,message = "District must be between 3 and 50 characters")
	private String city;
	
	@NotBlank(message="State cannot be empty")
	@Size(min=3,max=50,message = "State must be between 3 and 50 characters")
	private String state;
	
	public Address() {}
	
	
	public Address(
			@NotBlank(message = "Name cannot be empty") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String street,
			@NotNull(message = "Number cannot be null") Integer number,
			@NotBlank(message = "Cep cannot be empty") @Pattern(regexp = "/^[0-9]{5}-[0-9]{3}$/") String cep,
			@NotBlank(message = "District cannot be empty") @Size(min = 3, max = 50, message = "District must be between 3 and 50 characters") String district,
			@NotBlank(message = "District cannot be empty") @Size(min = 3, max = 50, message = "District must be between 3 and 50 characters") String city,
			@NotBlank(message = "State cannot be empty") @Size(min = 3, max = 50, message = "State must be between 3 and 50 characters") String state) {
		super();
		this.street = street;
		this.number = number;
		this.cep = cep;
		this.district = district;
		this.city = city;
		this.state = state;
	}


	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	@Override
	public String toString() {
		return "Endereco [street=" + street + ", number=" + number + ", cep=" + cep + ", district=" + district
				+ ", city=" + city + ", state=" + state + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cep, city, district, number, state, street);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city)
				&& Objects.equals(district, other.district) && Objects.equals(number, other.number)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street);
	}

	
}
