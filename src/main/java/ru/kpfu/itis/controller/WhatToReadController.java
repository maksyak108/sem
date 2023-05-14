package ru.kpfu.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.dto.ReviewResponseDto;
import ru.kpfu.itis.model.BookRaiting;
import ru.kpfu.itis.service.ReviewService;
import ru.kpfu.itis.service.WhatToReadService;

import java.util.List;

@Controller
@AllArgsConstructor
public class WhatToReadController {

    private final WhatToReadService whatToReadService;
    private final ReviewService reviewService;

    @GetMapping("/whatToRead")
    public String whatToRead(Model model, @RequestParam(name = "name", required = false) String name) {
        List<BookRaiting> books = whatToReadService.getAll();
        model.addAttribute("book", books);
        if (name != null) {
            List<ReviewResponseDto> reviewResponseDtos = reviewService.findAllByBookName(name);
            model.addAttribute("review", reviewResponseDtos);
        }
        return "whatToRead";
    }

}