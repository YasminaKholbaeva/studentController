package com.studentControl.controller;


import com.studentControl.service.ParentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import requests.ParentInfoRequest;

@RestController
@RequestMapping("/parent")
public class ParentController {
    @Autowired

    private ParentService parentService;
//    @GetMapping("/parentInfo")

    @PostMapping("/parentInfo")
    public ResponseEntity<String>
    parentInfo(@RequestBody ParentInfoRequest parent){
        String firstName = parent.firstName();
        String lastName = parent.lastName();
        String phone = parent.phone();
        String email = parent.email();
        return new ResponseEntity<>(parentService.parentInfo(firstName, lastName, phone, email), HttpStatus.CREATED);
    }

}
