package com.studentControl.service;

import com.studentControl.dto.Parent;
import com.studentControl.dto.repository.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    @Autowired
    private ParentRepo parentRepo;

    public List<Parent> getAllParents(){
        return parentRepo.findAll();
    }
    public Optional<Parent> findOneParent(Long id){
        return parentRepo.findById(id);
    }
    public String parentInfo (String firstName, String lastName, String phone, String email){
        Parent parent = new Parent();
        parent.setFirstName(firstName);
        parent.setLastName(lastName);
        parent.setPhone(phone);
        parent.setEmail(email);
        parentRepo.save(parent);

        return "Parent info entered successufully";
    }
}
