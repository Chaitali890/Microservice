package com.Quiz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz.entity.Quiz;
import com.Quiz.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	public  QuizService quizService;

	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}
	
	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizService.add(quiz);
	}

	@GetMapping
	public List<Quiz> getQuiz() {
		return quizService.get();
	}
	
	@GetMapping("/{id}")
	public Quiz getOneQuiz(@PathVariable Long id) {
		return quizService.get(id);
	}
	
}
