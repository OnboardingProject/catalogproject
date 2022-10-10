package com.ust.print.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
	
	@Id
	int id;
	
	@Column
	int rollNo;
	
	@Column
	String name;
	
	@Column
	String department;
	
	@Column
	String location;
	
	public Student() {
		super();
	}
	public Student(int id, int rollNo, String name, String department, String location) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.department = department;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", name=" + name + ", department=" + department
				+ ", location=" + location + "]";
	}
	
	

}
