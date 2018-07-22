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
        return answerRepository.getAllAnswersToQuestionId ( questionId );
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

    // This method retrieves all the answers posted by particular user id
    @Override
    public Iterable <Answer> getAllAnswersByUser(int userId) {
        return answerRepository.getAllAnswersByUserId ( userId );
    }

    // This method checks if there are any answers for the given question if
    @Override
    public Integer isQuestionIdForAnswerValid(int questionId) {
        return answerRepository.getCountOfAnswersForQuestion ( questionId );

    }
}