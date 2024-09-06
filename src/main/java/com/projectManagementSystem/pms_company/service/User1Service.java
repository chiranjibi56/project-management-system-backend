package com.projectManagementSystem.pms_company.service;


import com.projectManagementSystem.pms_company.Entity.User1;
import com.projectManagementSystem.pms_company.repository.User1Repository;
import org.springframework.stereotype.Service;

@Service
public class User1Service {

    private final User1Repository user1Repository;

    public User1Service (User1Repository user1Repository){
        this.user1Repository= user1Repository;
    }

    //creating user
    public String  saveUser1(User1 user1) {
        User1 savedUser1 = this.user1Repository.save(user1);
        if (savedUser1 != null) {
            return "success";
        } else {
            return "failed";
        }
    }

    //Getting user
    public User1 getUser(long userId){
        return user1Repository.findById(userId).get();
    }

    public User1 checkValidUser(User1 user1){
        User1 validatedUser = user1Repository.findUserByUserNameAndPassword(user1.getUserName(), user1.getPassword());
        if(validatedUser !=null){
            return validatedUser;
        }
        return user1;
    }

}
