package com.questions.service;

import java.util.List;

import com.questions.entity.Question;

public interface QuestionService {

	Question create(Question question);
	
	List<Question> getAllQuestion();
	
	Question getByQuestionId(Long id);
	
	List<Question> getQuestionOfQuiz(Long quizId);
	
}
