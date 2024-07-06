package com.cvct.cvctwebsite.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AnswerApiController {

    @PostMapping("/api/store-answers")
    public List<Map<String, String>> storeAnswers(HttpSession session, @RequestBody Map<String, String> answers) {
        List<Map<String, String>> answerList = (List<Map<String, String>>) session.getAttribute("answers");
        if (answerList == null) {
            answerList = new ArrayList<>();
        }
        answerList.add(answers);
        session.setAttribute("answers", answerList);
        return answerList;
    }
}
