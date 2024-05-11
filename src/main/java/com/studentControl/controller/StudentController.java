package com.studentControl.controller;


import com.studentControl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.StudentInfoRequest;

@RestController
@RequestMapping("/parent")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/Test")
    public String helloWorld(){
        return "Hello world";
    }

    @PostMapping("/studentInfo")
    public ResponseEntity<String>
    studentInfo(@RequestBody StudentInfoRequest student) {
        String firstName = student.firstName();
        String lastname = student.lastName();
        String phone = student.phone();
        String faculty = student.faculty();
        String birthday = student.birthday();
        String email = student.email();

        return new ResponseEntity<>(studentService.studentInfo(firstName, lastname, phone, faculty, birthday, email), HttpStatus.CREATED);
    }

}
