package org.upgrad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.model.Question;
import org.upgrad.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    // This method retrieves all the answers posted by user
    @Override
    public Iterable <Question> getAllQuestionsByUser(int id) {
        return questionRepository.getAllQuestionsByUserId ( id );
    }

    // This method find the userid of a particular question
    @Override
    public Integer findUserIdfromQuestion(int id) {
        return questionRepository.getQuestionIdByUserId ( id );
    }

    //This method delete the question with reference as questionId
    @Override
    public void deleteQuestionWithId(int id) {
        questionRepository.deleteQuestionById ( id );
    }

    @Override
    public List <Question> getAllQuestionsByCategory(Integer categoryId) {
        return questionRepository.getAllQuestionsByCategory ( categoryId );
    }

    @Override
    public List <Question> getAllQuestions() {
        return questionRepository.getAllQuestions ();
    }
}
