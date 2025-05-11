package com.example.handling_form_submission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This controller handles showing and processing a greeting form.
 */
@Controller
public class GreetingController {

    /**
     * Displays the greeting form.
     * It creates a new, empty Greeting object and adds it to the model so the form can be filled out.
     */
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    /**
     * Processes the submitted greeting form.
     * It receives the Greeting object filled in by the user, adds it to the model,
     * and returns the view name that displays the result.
     */
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }
}