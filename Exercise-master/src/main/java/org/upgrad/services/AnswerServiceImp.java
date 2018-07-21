package org.upgrad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.model.Answer;
import org.upgrad.repository.AnswerRepository;

import java.util.List;

@Service
public class AnswerServiceImp implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;


    @Override
    public List <Answer> getAllAnswersToQuestion(Integer questionId) {
        return null;
    }

    @Override
    public List <Answer> getAllAnswersByLikes(Integer questionId) {
        return answerRepository.getAllAnswersByLikes ( questionId );
    }

    @Override
    public void deleteAnswer(Integer answerId) {
        answerRepository.deleteAnswer ( answerId );
        // return answerId;
    }

    @Override
    public int findUserIdfromAnswer(int answerId) {
        return answerRepository.findUserIdfromAnswer ( answerId );
    }
}