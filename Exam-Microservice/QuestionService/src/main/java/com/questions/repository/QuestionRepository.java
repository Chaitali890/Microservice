package com.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questions.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

	List<Question> findByQuizId(Long quizId);
}
