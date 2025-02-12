package com.ether.journalApp.controller;

import com.ether.journalApp.entity.JournalEntity;
import com.ether.journalApp.entity.UserEntity;
import com.ether.journalApp.service.JEntryService;
import com.ether.journalApp.service.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JEntryController {

    @Autowired
    private UserEntryService userdb;

    @Autowired
    private JEntryService journaldb;

    @PostMapping("/create/{username}")
    public ResponseEntity<?> create(@RequestBody JournalEntity data,@PathVariable String username){
        try {
//            UserEntity user = userdb.findUsername(username);
//            if(user == null ) return  new ResponseEntity<>("User with this username is not present",HttpStatus.BAD_REQUEST);

            journaldb.create(data,username);

            return "successfully inserted data "+username;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<JournalEntity>> getAll(){
        try {
            Optional<List<JournalEntity>> res = Optional.ofNullable(journaldb.getAll());
            if(res.isPresent() && !res.get().isEmpty()){
                return new ResponseEntity<>(res.get(), HttpStatus.OK);
            } else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAll(){
        try {
            journaldb.deleteAll();
            return new ResponseEntity<>("Successfully deleted all journals",HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
