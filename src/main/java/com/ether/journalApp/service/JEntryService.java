package com.ether.journalApp.service;

import com.ether.journalApp.entity.JournalEntity;
import com.ether.journalApp.repository.JEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JEntryService {

    @Autowired
    private JEntryRepo db ;

    public void create(JournalEntity data, String username){
        db.save(data);

    }

    public List<JournalEntity> getAll(){
       return db.findAll();
    }

    public void deleteAll(){
        db.deleteAll();
    }

}
