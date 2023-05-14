package ru.kpfu.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.model.Book;
import ru.kpfu.itis.service.BooksService;

import java.util.List;

@Controller
@AllArgsConstructor
public class GenreController {

    private final BooksService booksService;

    @GetMapping("/genre")
    public String genre(Model model, @RequestParam(name = "genre", required = false) String genre) {
        if (genre != null && !genre.equals("Все")) {
            List<Book> books = booksService.findBooksByGenre(genre);
            model.addAttribute("book", books);
        } else {
            List<Book> books = booksService.getAll();
            model.addAttribute("book", books);
        }
        return "genre";
    }
}