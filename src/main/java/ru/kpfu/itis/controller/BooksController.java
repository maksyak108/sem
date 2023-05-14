package ru.kpfu.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.service.BooksService;

import java.util.List;

@Controller
@AllArgsConstructor
public class BooksController {

    private final BooksService bookService;

    @GetMapping("/mainPage")
    public String mainPage(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("book", books);
        return "mainPage";
    }
}