package com.api.student.service;

import com.api.student.dto.StudentDTO;
import com.api.student.entity.Student;
import com.api.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl
        implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public StudentDTO saveStudent(StudentDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        Student savedStudent =
                repository.save(student);

        StudentDTO response =
                new StudentDTO();

        response.setName(savedStudent.getName());
        response.setEmail(savedStudent.getEmail());

        return response;
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> students =
                repository.findAll();

        List<StudentDTO> dtoList =
                new ArrayList<>();

        for(Student student : students){

            StudentDTO dto =
                    new StudentDTO();

            dto.setName(student.getName());
            dto.setEmail(student.getEmail());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public StudentDTO updateStudent(Long id,
                                    StudentDTO dto) {

        Student student =
                repository.findById(id).orElse(null);

        if(student == null){
            return null;
        }

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        Student updated =
                repository.save(student);

        StudentDTO response =
                new StudentDTO();

        response.setName(updated.getName());
        response.setEmail(updated.getEmail());

        return response;
    }

    @Override
    public void deleteStudent(Long id) {

        repository.deleteById(id);
    }

    @Override
    public StudentDTO getStudentById(Long id) {

        Student student =
                repository.findById(id).orElse(null);

        if(student == null){
            return null;
        }

        StudentDTO dto = new StudentDTO();

        dto.setName(student.getName());
        dto.setEmail(student.getEmail());

        return dto;
    }
}