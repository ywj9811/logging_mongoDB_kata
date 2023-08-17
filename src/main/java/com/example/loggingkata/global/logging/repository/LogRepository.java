package com.example.loggingkata.global.logging.repository;

import com.example.loggingkata.global.logging.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends MongoRepository<Log, String> {
    List<Optional<Log>> findAllByLogType(String logType);
}