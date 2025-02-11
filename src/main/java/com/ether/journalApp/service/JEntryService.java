package com.ether.journalApp.service;

import com.ether.journalApp.entity.JDb;
import com.ether.journalApp.repository.JEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JEntryService {

    @Autowired
    private JEntryRepo db ;

    public void create(JDb data){
        db.save(data);
    }

    public List<JDb> getAll(){
       return db.findAll();
    }

    public void deleteAll(){
        db.deleteAll();
    }
}
