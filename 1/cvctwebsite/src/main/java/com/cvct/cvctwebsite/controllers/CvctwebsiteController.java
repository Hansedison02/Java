package com.cvct.cvctwebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.cvct.cvctwebsite.EmailSender;
import com.cvct.cvctwebsite.models.UserEntity;
import com.cvct.cvctwebsite.models.UserModel;
import com.cvct.cvctwebsite.services.UsersBusinessService;
import com.cvct.cvctwebsite.services.UsersBusinessServiceInterface;
import com.cvct.cvctwebsite.models.QuestionEntity;
import com.cvct.cvctwebsite.services.QuestionService;

import jakarta.servlet.http.HttpSession;

import com.cvct.cvctwebsite.data.UsersRepositoryInterface;

@Controller
public class CvctwebsiteController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UsersRepositoryInterface userRepository;

    @Autowired
    UsersBusinessServiceInterface service;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("ActivePage", "index");
        return "index";
    }

    @GetMapping("/about")
    public String showAboutPage(Model model) {
        model.addAttribute("ActivePage", "about-us");
        return "about-us";
    }

    @GetMapping("/contact")
    public String showContactPage(Model model) {
        model.addAttribute("ActivePage", "contact");
        return "contact";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) 
    {
        model.addAttribute("ActivePage", "login");
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("newUser", new UserModel());
        return "register";
    }

    @GetMapping("/example")
    public String showExamplePage(Model model) {
        return "example";
    }

    @GetMapping("/test")
    public String showTestPage(Model model) {
        QuestionEntity randomQuestion = questionService.getRandomQuestion();
        int numQuestions = 25;
        if (randomQuestion != null) {
            model.addAttribute("randomQuestion", randomQuestion.getQuestionName());
        }
        model.addAttribute("numQuestions", numQuestions);
        return "test";
    }
    @PostMapping("/test")
    public String handleTest(
            @RequestParam("fluency") int fluency,
            Model model,
            HttpSession session) {
                session.setAttribute("fluency", fluency);
                return "redirect:/result";
        }

    @PostMapping("/register")
    public String registerUser(UserModel newUser) {
        newUser.setRole("User");
        service.addOne(newUser);
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String showUsersPage(Model model) 
    {
        List<UserModel> users = service.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("newUser", new UserModel());
        return "users";
    }

    @GetMapping("/users/search/{searchTerm}")
    public List<UserModel> searchUsers(@PathVariable(name="searchTerm") String searchTerm)
    {
        List<UserModel> users = service.searchUsers(searchTerm);

        return users;
    }

    @PostMapping("/users")
    public String addUsers(@RequestBody UserModel model)
    {
        return service.addOne(model);
    }

    @GetMapping("/users/{id}")
    public UserModel getById(@PathVariable(name="id") String id)
    {
        return service.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteOne(@PathVariable(name="id") String id)
    {
        return service.deleteOne(id);
    }

    @PutMapping("/users/{id}")
    public UserModel updateOne(@RequestBody UserModel model, @PathVariable(name="id") String id)
    {
        return service.updateOne(id, model);
    }

    @GetMapping("/instructions")
    public String showInstructionsPage(Model model, HttpSession session) 
    {
        model.addAttribute("fname", session.getAttribute("fname"));
        return "instructions";
    }

    @GetMapping("/result")
    public String getResult(@RequestParam Map<String, String> answers, Model model, HttpSession session) {
        Map<String, Double> answerGuide = Map.of(
            "exampleAnswer1", 0.02,
            "exampleAnswer2", 0.1
            // Add more answers and their percentages here
        );

        Map<String, Object> scores = calculateScores(answers, answerGuide);

        model.addAllAttributes(scores);
        model.addAttribute("authUser", session.getAttribute("fname")); // Replace with actual user object retrieval

        return "result";
    }

    private Map<String, Object> calculateScores(Map<String, String> answers, Map<String, Double> answerGuide) {
        int fluencyScore = (int) answers.values().stream().filter(answer -> !answer.trim().isEmpty()).count();
        long uniqueAnswers = answers.values().stream().map(answer -> answer.trim().toLowerCase()).distinct().count();
        int flexibilityScore = fluencyScore - (fluencyScore - (int) uniqueAnswers);

        int originalityScore = answers.values().stream()
            .map(answer -> answer.trim().toLowerCase())
            .mapToInt(answer -> {
                double percentage = answerGuide.getOrDefault(answer, 0.0);
                if (percentage >= 0.1) return 1;
                if (percentage >= 0.05) return 2;
                if (percentage >= 0.01) return 3;
                return 4;
            })
            .sum();

        int elaborationScore = answers.values().stream()
            .mapToInt(answer -> {
                int wordCount = answer.trim().split("\\s+").length;
                return wordCount > 1 ? wordCount : 1;
            })
            .sum();

        int totalScore = fluencyScore + flexibilityScore + originalityScore + elaborationScore;
        String percentileScore = convertToPercentileForm(fluencyScore, flexibilityScore, originalityScore, elaborationScore, totalScore);

        return Map.of(
            "fluencyScore", fluencyScore,
            "flexibilityScore", flexibilityScore,
            "originalityScore", originalityScore,
            "elaborationScore", elaborationScore,
            "totalScore", totalScore,
            "percentileScore", percentileScore
        );
    }

    private String convertToPercentileForm(int fluency, int flexibility, int originality, int elaboration, int total) {
        if (fluency >= 9 && flexibility >= 8 && originality >= 15 && elaboration >= 10 && total >= 301) {
            return "Q4";
        } else if (fluency >= 8 && flexibility >= 7 && originality >= 12 && elaboration >= 9 && total >= 190) {
            return "Q3";
        } else if (fluency >= 7 && flexibility >= 6 && originality >= 10 && elaboration >= 7 && total >= 100) {
            return "Q2";
        }
        return "Q1";
    }

    @PostMapping("/contact")
    public String handleContactSubmission(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("message") String message,
            Model model) {

        String to = "cvct.team@gmail.com";
        String subject = "Contact Form Submission from " + name;

        EmailSender.sendEmail(to, email, subject, message);

        model.addAttribute("successMessage", "Thank you for contacting us. We will get back to you shortly.");

        return "contact";
        }

    @PostMapping("/login")
    public String handleLogin(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {

        UserEntity user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("fname", user.getFname());
            session.setAttribute("lname", user.getLname());
            if ("Admin".equals(user.getRole())) {
                return "redirect:/users";
            } else if ("User".equals(user.getRole())) {
                return "redirect:/instructions";
            }
        }

        model.addAttribute("status", "Invalid email or password");
        return "login";
    }
}