package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositoryInterface extends JpaRepository<Student, Long>{
    
    // updates name and email of a student
    @Modifying
    @Query("UPDATE students SET name = ?2, email = ?3 WHERE id = ?1")
    public void editNameAndEmail(Long id, String name, String email);

}
