package com.cvct.cvctwebsite.data;

import com.cvct.cvctwebsite.models.QuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepositoryInterface extends MongoRepository<QuestionEntity, String> {
}