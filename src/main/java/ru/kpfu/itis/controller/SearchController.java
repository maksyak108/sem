package ru.kpfu.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.service.BooksService;

@Controller
@AllArgsConstructor
public class SearchController {

    private final BooksService booksService;
    @GetMapping("/search")
    public String search(Model model, @RequestParam(name = "name", required = false) String name) {
        if (name != null) {
            Book book = booksService.findBookByName(name);
            model.addAttribute("book", book);
        } else {
            Book book = booksService.findBookByName("_");
            model.addAttribute("book", book);
        }
        return "search";
    }
}