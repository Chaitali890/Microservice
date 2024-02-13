package com.questions.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questions.entity.Question;
import com.questions.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	
	@PostMapping
	public Question createQuestion(@RequestBody Question question) {
		return questionService.create(question);
	}
	
	@GetMapping
	public List<Question> GetAllQuestion() {
		return questionService.getAllQuestion();
	}
	
	
	@GetMapping("/{id}")
	public Question GetQuestionById(@PathVariable Long id) {
		return questionService.getByQuestionId(id);
	}
	
	@GetMapping("/quiz/{quizId}")
	public List<Question> GetAllQuestion(@PathVariable Long quizId) {
		return questionService.getQuestionOfQuiz(quizId);
	}
	
}
