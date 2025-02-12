package com.ether.journalApp.repository;

import com.ether.journalApp.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntryRepo extends MongoRepository<UserEntity, ObjectId> {
    UserEntity findByUsername(String username);
}
