package com.leonardoboff.RealShopMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leonardoboff.RealShopMongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
