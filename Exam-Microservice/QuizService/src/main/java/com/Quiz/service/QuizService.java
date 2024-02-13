package com.Quiz.service;

import java.util.List;

import com.Quiz.entity.Quiz;

public interface QuizService {

	Quiz add(Quiz quiz);
	
	List<Quiz> get();
	
	Quiz get(Long id);
}
