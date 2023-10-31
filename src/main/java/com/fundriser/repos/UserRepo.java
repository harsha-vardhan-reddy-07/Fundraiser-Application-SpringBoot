package com.fundriser.repos;

import com.fundriser.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserModel, String> {
    UserModel findByEmail(String email);
}
