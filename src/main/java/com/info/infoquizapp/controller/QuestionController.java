package com.info.infoquizapp.controller;

import com.info.infoquizapp.entity.Question;
import com.info.infoquizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionController {

    QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("questions/{categoryName}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String categoryName){
        return questionService.getQuestionsByCategory(categoryName);
    }

    @PostMapping("questions")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("questions")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }
    @DeleteMapping("questions/{questionId}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable int questionId){
        return questionService.deleteQuestionById(questionId);
    }
}
