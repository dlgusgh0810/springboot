package com.Lect.week09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("regist")
public class BasicProcessController1 {
    @GetMapping("/step/{id}")
    public String detail(@PathVariable("id") Long stepId) {
        String viewName = "registerStep" + stepId;
        return "week09/" + viewName;
    }
    @PostMapping("/step2")
    public String handleStep2(@RequestParam("view") String view,
                              @RequestParam(value="agree", defaultValue = "false")
                                Boolean agree,
                              RedirectAttributes redirectAttributes) {
        if(!agree) {
            redirectAttributes.addFlashAttribute("message", "약관 동의를 해주세요.");
            return "redirect:http://localhost:8080/regist/step/1";
        }
        return "week09/" + view;
    }
}
