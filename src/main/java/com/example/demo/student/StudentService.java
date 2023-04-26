package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    StudentRepositoryInterface repository;

    @Autowired
    public StudentService(StudentRepositoryInterface studentRepository) {
        this.repository = studentRepository;
    }

    public List<Student> getStudents() {
        try {
            return this.repository.findAll();
        } catch(Exception e) {
            return null;
        }
    }

    public Student getStudentById(Long id) {
        return this.repository.findById(id).get();
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public void createStudent(Student student) {
        this.repository.save(student);
    }

    public void editStudent(StudentUpdateRequest updateRequest, Long id) {
        this.repository.editNameAndEmail(id, updateRequest.name, updateRequest.email);
    }

    
}
