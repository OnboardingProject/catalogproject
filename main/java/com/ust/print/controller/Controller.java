package com.ust.print.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.print.dto.EmployeeDto;
import com.ust.print.entity.Employee;
import com.ust.print.service.ServicePrint;

@RestController
@RequestMapping("/v1")
public class Controller {

	@Autowired
	ServicePrint serve;

	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> getPtint() {

		List<EmployeeDto> data = serve.getData();

		data.forEach(a -> System.out.println(a));

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@PostMapping("/employee")
	public ResponseEntity<?> getEmployee(@RequestBody Employee employee) {

		String data = serve.saveEmployee(employee);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@PostMapping("/employees")
	public ResponseEntity<?> getEmployee(@RequestBody List<Employee> employee) {

		String data = serve.saveEmployees(employee);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> viewEmployee(@PathVariable int id) {

		Employee data = serve.getEmployeeById(id);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<?> viewAllEmployee() {

		List<Employee> data = serve.getAllEmployee();

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@GetMapping("/filter")
	public ResponseEntity<?> viewAllEmployeeStream() {

		List<Employee> emp = serve.getAllEmployeeFilter();
		return new ResponseEntity<>(emp, HttpStatus.OK);

	}

	@GetMapping("/for")
	public void EmployeeStream() {

		serve.getAllEmployee().stream().filter(a -> a.getDepatment().equalsIgnoreCase("hr"))
				.forEach(a -> System.out.println(a));

	}

	@GetMapping("/map")
	public ResponseEntity<?> viewAllEmployeeMap() {

		List<Employee> emp = serve.getAllEmployeeMap();
		return new ResponseEntity<>(emp, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteEmployee(@PathVariable int id) {

		String data = serve.deleteEmployee(id);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}
}
