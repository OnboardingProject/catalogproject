package com.ust.print.dto;

public class StudentDto {
	public StudentDto() {
		super();
	}
	public StudentDto(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	String name;
	String location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocationt(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", location=" + location + "]";
	}
	

	
	
	
}
