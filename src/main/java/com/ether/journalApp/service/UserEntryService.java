package com.ether.journalApp.service;

import com.ether.journalApp.entity.UserEntity;
import com.ether.journalApp.repository.UserEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserEntryService {

    @Autowired
    UserEntryRepo userdb;

    public String create(UserEntity user){
        try {
            userdb.save(user);
            return "User created";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserEntity> getAll(){
        try {
        return userdb.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserEntity findUsername(String username){
        try {
            return userdb.findByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
