package com.cvct.cvctwebsite.services;

import com.cvct.cvctwebsite.models.QuestionEntity;
import com.cvct.cvctwebsite.data.QuestionRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepositoryInterface questionRepository;

    public QuestionEntity getRandomQuestion() {
        List<QuestionEntity> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            return null; // or throw an exception if preferred
        }
        Random random = new Random();
        int randomIndex = random.nextInt(questions.size());
        return questions.get(randomIndex);
    }
}