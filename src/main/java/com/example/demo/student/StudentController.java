package com.example.demo.student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("api/v1/student")
public class StudentController {

	StudentServiceInterface studentService;

	public StudentController(StudentServiceInterface studentService) {
		try {
			this.studentService = studentService;
		} catch(Exception e) {

		}
	}

	@GetMapping ("/getall")
	public List<Student> getStudents() {
		return this.studentService.getStudents();
	}

	@GetMapping ("/get/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return this.studentService.getStudentById(id);
	}

	@DeleteMapping ("/deleteall")
	public void deleteStudents() {
		this.studentService.deleteAll();
	}

	@DeleteMapping ("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		this.studentService.deleteById(id);
	}

	@PostMapping ("/createstudent")
	public void createStudent(@RequestBody Student student) {
		this.studentService.createStudent(student);
	}

	@PutMapping ("/edit/{id}")
	public void editStudent(@RequestBody StudentUpdateRequest updateRequest, @PathVariable Long id) {
		this.studentService.editStudent(updateRequest, id);
	}
}
