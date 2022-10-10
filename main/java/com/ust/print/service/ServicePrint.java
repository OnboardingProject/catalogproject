package com.ust.print.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.print.dto.EmployeeDto;
import com.ust.print.entity.Employee;
import com.ust.print.repository.EmployeeRepo;

@Service
public class ServicePrint {

	@Autowired
	EmployeeRepo repo;

	public List<EmployeeDto> getData() {
		List<EmployeeDto> emp = new ArrayList<EmployeeDto>();
		emp.add(new EmployeeDto(1, "anu", 10000, "tester"));
		emp.add(new EmployeeDto(2, "ammu", 90000, "hr"));
		emp.add(new EmployeeDto(3, "arya", 80000, "developer"));
		emp.add(new EmployeeDto(4, "manu", 75000, "tester"));
		// emp.forEach(a->System.out.println(a));
		return emp;
	}

	public String saveEmployee(Employee employee) {
		try {
			repo.save(employee);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public String saveEmployees(List<Employee> employee) {
		try {
			repo.saveAll(employee);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	public Employee getEmployeeById(int id) {

		Employee emp = repo.findById(id).get();
		return emp;

	}

	public List<Employee> getAllEmployee() {

		return repo.findAll();

	}

	// public List<Employee> getAllEmployeeFor() {

	// return repo.findAll().stream().forEach(System.out::println);

	// }

	public List<Employee> getAllEmployeeMap() {

		List<Employee> emp = repo.findAll().stream().map(a -> {
			a.setSalary(a.getSalary());
			return a;
		}).collect(Collectors.toList());

		return emp;

	}

	public List<Employee> getAllEmployeeFilter() {

		List<Employee> emp = repo.findAll().stream().filter(a -> a.getDepatment().equalsIgnoreCase("hr"))
				.collect(Collectors.toList());
		return emp;

	}

	public String deleteEmployee(int id) {

		repo.deleteById(id);
		return "deleted";

	}

}
