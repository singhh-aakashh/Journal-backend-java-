package com.ether.journalApp.repository;


import com.ether.journalApp.entity.JDb;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JEntryRepo extends MongoRepository<JDb,String> {
}
