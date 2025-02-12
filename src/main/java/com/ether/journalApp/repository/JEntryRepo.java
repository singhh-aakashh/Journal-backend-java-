package com.ether.journalApp.repository;


import com.ether.journalApp.entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JEntryRepo extends MongoRepository<JournalEntity,String> {
}
