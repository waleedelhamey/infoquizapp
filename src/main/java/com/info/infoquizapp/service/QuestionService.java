package com.info.infoquizapp.service;

import com.info.infoquizapp.dao.QuestionDao;
import com.info.infoquizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    QuestionDao questionDao;

    @Autowired
    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public ResponseEntity<List<Question>>getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Question>> getQuestionsByCategory(String categoryName) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(categoryName), HttpStatus.OK);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> deleteQuestionById(int questionId) {
        questionDao.deleteById(questionId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
