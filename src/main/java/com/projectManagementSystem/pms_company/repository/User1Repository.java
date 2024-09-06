package com.projectManagementSystem.pms_company.repository;

import com.projectManagementSystem.pms_company.Entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface User1Repository extends JpaRepository<User1, Long> {

    public User1 findUserByUserNameAndPassword(String username, String password);

}
