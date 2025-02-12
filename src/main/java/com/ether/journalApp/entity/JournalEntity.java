package com.ether.journalApp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class JournalEntity {
    @Id
    private String id;
    private String title;
    private String content;


}

