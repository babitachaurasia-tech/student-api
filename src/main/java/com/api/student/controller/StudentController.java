package com.api.student.controller;

import com.api.student.dto.StudentDTO;
import com.api.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public StudentDTO createStudent(
            @RequestBody StudentDTO dto){

        return service.saveStudent(dto);
    }

    @GetMapping
    public List<StudentDTO> getAllStudents(){

        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getStudent(
            @PathVariable Long id){

        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentDTO updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDTO dto){

        return service.updateStudent(id,dto);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id){

        service.deleteStudent(id);

        return "Student Deleted";
    }
}
