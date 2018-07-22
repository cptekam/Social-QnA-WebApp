package org.upgrad.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.upgrad.model.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository <Answer, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM answer where id = ?1")
    void deleteAnswer(Integer answerId);

    @Query(nativeQuery = true, value = "SELECT a.id, a.ans, a.date, a.user_id, a.question_id, a.modifiedon ," + "" + " COUNT(a.id) countlikes FROM answer a JOIN likes l ON a.id =  l.answer_id WHERE a.question_id = ?1" + "" + " GROUP BY a.id ORDER BY  countlikes DESC")
    List <Answer> getAllAnswersByLikes(Integer question_id);

    @Query(nativeQuery = true, value = "SELECT user_id FROM answer where id = ?1")
    int findUserIdfromAnswer(int answerId);

    @Query(nativeQuery = true, value = "SELECT * FROM answer WHERE question_id= ?1 ")
    List <Answer> getAllAnswersToQuestionId(int questionId);

    @Query(nativeQuery = true, value = "SELECT * FROM answer WHERE user_id= ?1 ")
    Iterable <Answer> getAllAnswersByUserId(int userId);

    @Query(nativeQuery = true, value = "SELECT count(*) from answer WHERE question_id= ?1")
    Integer getCountOfAnswersForQuestion(int questionId);

}