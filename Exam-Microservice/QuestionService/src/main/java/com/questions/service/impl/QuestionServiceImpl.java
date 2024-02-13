package com.questions.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.questions.entity.Question;
import com.questions.repository.QuestionRepository;
import com.questions.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	
	private QuestionRepository questionRepository;
	
	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	public Question create(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getAllQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public Question getByQuestionId(Long id) {
		return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
	}

	@Override
	public List<Question> getQuestionOfQuiz(Long quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
