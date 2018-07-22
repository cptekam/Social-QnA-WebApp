package org.upgrad.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.upgrad.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository <Question, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM question WHERE user_id= ?1 ")
    Iterable <Question> getAllQuestionsByUserId(int id);

    @Query(nativeQuery = true, value = "SELECT user_id FROM question WHERE id= ?1 ")
    Integer getQuestionIdByUserId(int id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM question WHERE id= ?1 ")
    void deleteQuestionById(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM question")
    List <Question> getAllQuestions();


    @Query(nativeQuery = true, value = "SELCT * FROM questiion q INNER JOIN questiion_category qc ON q.id = " + " qc.question_id where qc.category_id = ?1")
    List <Question> getAllQuestionsByCategory(Integer categoryId);
}
