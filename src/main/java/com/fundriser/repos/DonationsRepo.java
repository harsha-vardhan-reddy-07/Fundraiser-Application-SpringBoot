package com.fundriser.repos;

import com.fundriser.models.DonationsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonationsRepo extends MongoRepository<DonationsModel, String> {
}
