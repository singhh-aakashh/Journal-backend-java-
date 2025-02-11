package com.ether.journalApp.controller;

import com.ether.journalApp.entity.JDb;
import com.ether.journalApp.service.JEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JEntryController {

    @Autowired
    private JEntryService dbservice;

    @PostMapping("/create")
    public String create(@RequestBody JDb data){
        try {
            dbservice.create(data);
            return "successfully inserted data";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get")
    public List<JDb> getAll(){
        try {
            return dbservice.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete-all")
    public String deleteAll(){
        try {
            dbservice.deleteAll();
            return "Success";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
