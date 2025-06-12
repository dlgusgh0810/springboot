package com.Lect.week10;


import com.Lect.week09.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicProcessController2 {
    @GetMapping({"/message", "/validation","/register","/globalValidator"})
    public String membershipForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "week10/registerForm";
    }
}
