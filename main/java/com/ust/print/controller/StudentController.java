package com.ust.print.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.print.dto.StudentDto;
import com.ust.print.entity.Student;
import com.ust.print.service.StudentService;

@RestController
@RequestMapping("/v2")
@CrossOrigin
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	
	Logger logger=LoggerFactory.getLogger(StudentController.class);
	

	@PostMapping("/savestudents")
	public ResponseEntity<?> getStudent(@RequestBody List<Student> students) {

		String data = studentService.saveStudents(students);
		return new ResponseEntity<>(data, HttpStatus.OK);

	}
	
	@PostMapping("/savestudent")
	public ResponseEntity<?> getStudent(@RequestBody Student student) {

		String data = studentService.saveStudent(student);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}
	@GetMapping("/location")
	public ResponseEntity<?> viewAllStudentStream() {

		List<StudentDto> stu = studentService.getAllStudent();
		logger.info("new data added");
		return new ResponseEntity<>(stu, HttpStatus.OK);

	}
}
