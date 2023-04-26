package com.example.demo.student;

import java.util.List;

public interface StudentServiceInterface {
    public List<Student> getStudents();

    public Student getStudentById(Long id);

    public void deleteAll();

    public void deleteById(Long id);

    public void createStudent(Student student);

    public void editStudent(StudentUpdateRequest updateRequest, Long id);
}
