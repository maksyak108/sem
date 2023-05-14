package ru.kpfu.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.model.KidsBook;
import ru.kpfu.itis.service.KidsBookService;

import java.util.List;

@Controller
@AllArgsConstructor
public class KidsBookController {

    private final KidsBookService kidsBookService;

    @GetMapping("/forKids")
    public String forKids(Model model) {
        List<KidsBook> kidsBooks = kidsBookService.getAll();
        model.addAttribute("book", kidsBooks);
        return "forKids";
    }
}
