package com.ust.print.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.print.entity.Student;
import com.ust.print.dto.StudentDto;
import com.ust.print.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	Logger logger=LoggerFactory.getLogger(StudentService.class);
	
	
	
	

	public String saveStudents(List<Student> students) {
		try {
			studentRepo.saveAll(students);
			logger.info("successfully added");
			return "success";
		} catch (Exception e) {
			System.out.println(e);
			logger.error("try again");
			return "error";
		}
	}

	public String saveStudent(Student student) {
		try {
			studentRepo.save(student);
			logger.info("successfully added");
			return "success";
		} catch (Exception e) {
			
			System.out.println(e);
			logger.error("try again");
			return "error";
		}
	}
	public List<StudentDto> getAllStudent() {
		
		List<StudentDto> updatedList = new ArrayList<>();
		try {
		studentRepo.findAll().stream().forEach(a -> {
			StudentDto stDto=new StudentDto();
			stDto.setName(a.getName());
			stDto.setLocationt("trivandrum");
			updatedList.add(stDto);
		});
		}catch(Exception e)
		{
			System.out.println("error");
		}
		return updatedList;
	}

}
