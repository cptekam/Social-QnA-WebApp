package org.upgrad.services;

import org.springframework.stereotype.Service;
import org.upgrad.model.Answer;

import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService {

    @Autowired
    private AnswerRepository  answerRepository;
    
    @Override
    public List <Answer> getAllAnswersToQuestion(Integer questionId) {
        return null;
    }

    @Override
    public List <Answer> getAllAnswersByLikes(Integer questionId) {
        return  answerRepository.getAllAnswersByLikes(questionId);;
    }

    @Override
    public Integer findUserIdfromAnswer(Integer answerId) {
        return null;
    }
}
