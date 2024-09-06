package com.projectManagementSystem.pms_company.controller;

import com.projectManagementSystem.pms_company.Entity.User1;
import com.projectManagementSystem.pms_company.service.User1Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/pms/api/v1/users1")
public class User1Controller {

    private final User1Service user1Service;

    public User1Controller(User1Service user1Service) {
        this.user1Service = user1Service;
    }

    //saving user
    //URL: http://localhost/4040/user1
    @PostMapping
    public ResponseEntity<String> savingUser1(@RequestBody User1 user1){
      return ResponseEntity.ok(this.user1Service.saveUser1(user1));
    }

    //Checking user
    @PostMapping("/login")
    public ResponseEntity<User1> checkValidUser(@RequestBody User1 user1){
        System.out.println("checking valid user ......... login");
        return ResponseEntity.ok(this.user1Service.checkValidUser(user1));
    }
}
