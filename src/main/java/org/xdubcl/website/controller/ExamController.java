package org.xdubcl.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xdubcl.website.service.ExamService;

@Controller
@RequestMapping("/exam")
public class ExamController {

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
}
