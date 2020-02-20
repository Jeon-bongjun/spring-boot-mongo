package com.ivi.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ivi.service.model.User;

public interface UserRespository extends MongoRepository<User, Long>{
	
    public List<User> findById(String id);
    public List<User> findAll();
    
}

