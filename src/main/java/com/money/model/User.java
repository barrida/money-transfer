package com.money.model;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int userId;
	private String name;
	private String surname;
	private String dob;
	private String phone;
	private String country;
	private String postalCode;
	private String address;
    private String email;
    
	public User(int userId, String name, String surname, String dob, String phone, String country, String postalCode,
			String address, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.phone = phone;
		this.country = country;
		this.postalCode = postalCode;
		this.address = address;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", phone="
				+ phone + ", country=" + country + ", postalCode=" + postalCode + ", address=" + address + ", email="
				+ email + ", getUserId()=" + getUserId() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getDob()=" + getDob() + ", getPhone()=" + getPhone() + ", getCountry()=" + getCountry()
				+ ", getPostalCode()=" + getPostalCode() + ", getAddress()=" + getAddress() + ", getEmail()="
				+ getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}    
	
	
	
    
    
}
