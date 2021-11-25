package org.xdubcl.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/problem")
public class ProblemController {

    @GetMapping("/exam")
    public String exam(){
         examService.generate();
         return "randomPage";
    }
}
