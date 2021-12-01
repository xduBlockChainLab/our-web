package org.xdubcl.website.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/suggest")
public class SuggestionController {

    @GetMapping("/suggestpage")
    public String homepage(){

        return "pageofsuggestion";
    }
}
