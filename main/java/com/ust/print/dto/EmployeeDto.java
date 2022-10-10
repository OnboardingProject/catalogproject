package com.ust.print.dto;

public class EmployeeDto {


	 int id;
	 String Name;
	 int Salary;
	 String depatment;
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(int id, String name, int salary, String depatment) {
		super();
		this.id = id;
		Name = name;
		Salary = salary;
		this.depatment = depatment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getDepatment() {
		return depatment;
	}
	public void setDepatment(String depatment) {
		this.depatment = depatment;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", Name=" + Name + ", Salary=" + Salary + ", depatment=" + depatment + "]";
	}
	 
}
