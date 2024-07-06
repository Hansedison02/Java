package com.cvct.cvctwebsite.data;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cvct.cvctwebsite.models.UserEntity;

public interface UsersRepositoryInterface extends MongoRepository<UserEntity, String> {

    @Query("{'username':{'$regex':'?0', '$options':'i'}}")
    List<UserEntity> findByUsername(String searchTerm);

    UserEntity findByEmail(String email);

    UserEntity findByFname(String fname);
}
