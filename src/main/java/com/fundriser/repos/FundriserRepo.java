package com.fundriser.repos;

import com.fundriser.models.FundriserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FundriserRepo extends MongoRepository<FundriserModel, String> {
}
