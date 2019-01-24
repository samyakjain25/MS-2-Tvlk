package com.traveloka.ecommerce.repository;

import com.traveloka.ecommerce.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
	public User findOneByName(String name);
}
