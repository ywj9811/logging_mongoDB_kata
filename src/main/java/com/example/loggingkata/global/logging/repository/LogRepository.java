package com.example.loggingkata.global.logging.repository;

import com.example.loggingkata.global.logging.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
}