package com.api.student.repository;

import com.api.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
}
