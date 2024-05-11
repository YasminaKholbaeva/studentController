package com.studentControl.service;

import com.studentControl.dto.Student;
import com.studentControl.dto.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
     public List<Student> getAllStudents(){
         return studentRepo.findAll();
     }
     public Optional<Student> findOneStudent(Long id){
         return studentRepo.findById(id);
     }
     public String studentInfo(String firstName, String lastName, String phone, String faculty, String email, String birthday){
         Student student = new Student();
         student.setFirstName(firstName);
         student.setLastName(lastName);
         student.setPhone(phone);
         student.setFaculty(faculty);
         student.setEmail(email);
         student.setBirthday(birthday);
         studentRepo.save(student);

         return "Student info entered successfully";
     }

}
