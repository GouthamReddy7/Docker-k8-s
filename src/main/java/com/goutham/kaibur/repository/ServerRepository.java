package com.goutham.kaibur.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.goutham.kaibur.model.Server;



public interface ServerRepository extends MongoRepository<Server, String> {


}
