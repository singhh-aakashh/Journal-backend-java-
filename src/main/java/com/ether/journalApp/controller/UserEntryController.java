package com.ether.journalApp.controller;

import com.ether.journalApp.entity.UserEntity;
import com.ether.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntryController {

    @Autowired
    UserEntryService userService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody UserEntity user){
            try {
                userService.create(user);
                return new ResponseEntity<>("Created user",HttpStatus.CREATED);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<UserEntity>> getAll(){
        List<UserEntity> list;
        try {
             list = userService.getAll();
            System.out.println(list);
             return new ResponseEntity<>(list,HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<?> findUser(@PathVariable String username){
        try {
            UserEntity user = userService.findUsername(username);
            if(user==null){
                return new ResponseEntity<>("User does not exists",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
