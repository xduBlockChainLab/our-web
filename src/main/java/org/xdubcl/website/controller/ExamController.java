package org.xdubcl.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xdubcl.website.model.Problem;
import org.xdubcl.website.model.User;
import org.xdubcl.website.repository.ProblemRepository;
import org.xdubcl.website.repository.UserRepository;
import org.xdubcl.website.service.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController {


    @Autowired
    private ProblemRepository repo;

    @Autowired
    ExamService examService;

    @GetMapping("")
    public String exam(){
         examService.generate();
         return "randomPage";
    }

    @GetMapping("/result")
    public String result(){
        examService.judge();
        return "result";
    }


//创建一个problem对象，用于存储它的信息
    @GetMapping("/addpage")
    public String ShowAddPage(Model model) {
        model.addAttribute("problem", new Problem());

        return "AddQuestion";
    }


    @PostMapping("/addQuestion")
    public String processRegistration(Problem problem) {


        repo.save(problem);

        return "AddQuestionSuccessfully";
    }


    @GetMapping("/list_problems")
    public String viewquestionlist(Model model) {
        Iterable<Problem> listQuestions = repo.findAll();
        model.addAttribute("listquestions", listQuestions);

        return "checkquestions";
    }



}
