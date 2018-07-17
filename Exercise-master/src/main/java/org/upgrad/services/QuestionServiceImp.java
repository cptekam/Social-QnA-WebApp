package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.Question;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public List <Question> getAllQuestionsByCategory(Integer categoryId) {
        return questionRepository.getAllQuestionsByCategory(categoryId);
    }
}
