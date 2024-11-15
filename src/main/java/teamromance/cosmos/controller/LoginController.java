package teamromance.cosmos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // loginForm.html 반환
    @GetMapping("/login")
    public String loginForm(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "loginForm";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "access-denied";
    }
}