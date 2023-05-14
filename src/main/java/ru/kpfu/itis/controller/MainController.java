package ru.kpfu.itis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.dto.CreateUserRequestDto;


@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/sign_up")
    public String signUp(Model model) {
        model.addAttribute("user", new CreateUserRequestDto());
        return "sign_up";
    }

    @GetMapping("/login")
    public String login() {
        return "login_page";
    }
}
