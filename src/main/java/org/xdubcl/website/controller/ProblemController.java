package org.xdubcl.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xdubcl.website.service.ExamService;

@Controller
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    ExamService examService;

    @GetMapping("/exam")
    public String exam(){
         examService.generate();
         return "randomPage";
    }
}
