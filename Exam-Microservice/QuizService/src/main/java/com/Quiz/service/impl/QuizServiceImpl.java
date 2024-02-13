package com.Quiz.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Quiz.entity.Quiz;
import com.Quiz.repository.QuizRepository;
import com.Quiz.service.QuestionClient;
import com.Quiz.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService {

	private QuizRepository quizRepository;
	
	private QuestionClient questionClient;
	
	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz add(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		//return quizRepository.findAll();
		
		List<Quiz> quizzes = quizRepository.findAll();
		
		List<Quiz> newQuizList = quizzes.stream().map(quiz -> {
			quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		
		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {
		//return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
		Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
		quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

	
}
