package org.upgrad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.upgrad.model.Question;

import java.util.List;

@Repository
public interface QuestionRespository extends CrudRepository <Question, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM question")
    List <Question> getAllQuestions();


    @Query(nativeQuery = true, value = "SELCT * FROM questiion q INNER JOIN questiion_category qc ON q.id = " + " qc.question_id where qc.category_id = ?1")
    List <Question> getAllQuestionsByCategory(Integer categoryId);
}
