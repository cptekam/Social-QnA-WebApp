package org.upgrad.services;

import org.upgrad.model.Answer;

import java.util.List;

public interface AnswerService {
    List <Answer> getAllAnswersToQuestion(Integer questionId);

    List <Answer> getAllAnswersByLikes(Integer questionId);

    int findUserIdfromAnswer(int answerId);

    void deleteAnswer(Integer answerId);

    Iterable <Answer> getAllAnswersByUser(int userId);

    Integer isQuestionIdForAnswerValid(int questionId);
}
