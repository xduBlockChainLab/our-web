package org.xdubcl.website.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xdubcl.website.model.Problem;
import org.xdubcl.website.model.Suggestion;
import org.xdubcl.website.repository.ProblemRepository;
import org.xdubcl.website.repository.SuggestionRepository;

@Controller
@RequestMapping("/suggest")
public class SuggestionController {



    @Autowired
    private SuggestionRepository repo;


    @GetMapping("/suggestpage")
    public String ShowSuggestPage(Model model) {
        model.addAttribute("suggestion", new Suggestion());

        return "pageofsuggestion";
    }

    @PostMapping("/addSuggestion")
    public String processAddSuggestion(Suggestion suggestion) {


        repo.save(suggestion);

        return "AddSuggestionSuccessfully";

    }
    }
