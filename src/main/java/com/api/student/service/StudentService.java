package com.api.student.service;
import com.api.student.dto.StudentDTO;
import java.util.List;

public interface StudentService {

    StudentDTO saveStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(Long id, StudentDTO dto);

    void deleteStudent(Long id);

    StudentDTO getStudentById(Long id);
}
