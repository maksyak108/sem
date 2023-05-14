package ru.kpfu.itis.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.dto.CreateUserRequestDto;
import ru.kpfu.itis.dto.ReviewResponseDto;
import ru.kpfu.itis.dto.UserResponseDto;
import ru.kpfu.itis.model.User;
import ru.kpfu.itis.service.BooksRaitingService;
import ru.kpfu.itis.service.BooksService;
import ru.kpfu.itis.service.ReviewService;
import ru.kpfu.itis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ReviewService reviewService;

    private final BooksRaitingService booksRaitingService;

    private final BooksService booksService;

    @ResponseBody
    @GetMapping(value = {"/users/{id}", "users"})
    public List<UserResponseDto> user(@PathVariable(required = false) Optional<Integer> id) {
        if (id.isPresent()) {
            return List.of(userService.findById(id.get()).get());
        } else {
            return userService.findAll();
        }
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute CreateUserRequestDto user, HttpServletRequest request) {
        String url = request.getRequestURL().toString().replace(request.getServletPath(), "");
        userService.create(user, url);
        return "sign_up_success";
    }

    @GetMapping("/home/{id}")
    public String showProfile(@PathVariable("id") Integer id, Model model, Principal principal) {
        return "home";
    }

    @GetMapping("/home")
    public String showProfile(HttpServletRequest httpServletRequest, Model model, Principal principal, @RequestParam(name = "id", required = false) Integer id) {
        if (id != null) {
            String bookName = reviewService.getNameById(id);
            Integer number = booksRaitingService.getNumberByName(bookName);
            Double raiting = booksRaitingService.getMarkByName(bookName);
            if(number == 1){
                number = 0;
                raiting = 0.0;
            }else {
                double x = number - 1;
                raiting = (raiting * number - 5) / x;
                number -= 1;
            }
            booksRaitingService.updateRaiting(number, raiting, bookName);
            reviewService.deleteReviewById(id);
        }
        String currentPrincipalName = httpServletRequest.getUserPrincipal().getName();
        String email = principal.getName();
        User user = userService.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));
        List<ReviewResponseDto> reviewResponseDtos = reviewService.findAllByAuthor(email);
        model.addAttribute("user", user);
        model.addAttribute("review", reviewResponseDtos);
        return "home";
    }

    @GetMapping("/review")
    public String review(Principal principal, @RequestParam(name = "name", required = false) String name, @RequestParam(name = "review", required = false) String review, @RequestParam(name = "score", required = false) String score) {
        System.out.println(name);
        System.out.println(review);
        System.out.println(score);
        if(name != null && review != null && score != null) {
            String email = principal.getName();
            Integer bookId = booksService.findBookByName(name).getId();
            reviewService.saveReview(email, review, name, bookId, Integer.parseInt(score));
            Integer number = booksRaitingService.getNumberByName(name);
            Double raiting = booksRaitingService.getMarkByName(name);
            raiting = (raiting * number + Integer.parseInt(score)) / (number + 1);
            number += 1;
            booksRaitingService.updateRaiting(number, raiting, name);
        }
        return "review";
    }

    @GetMapping("/verification")
    public String verify(@Param("code") String code) {
        if (userService.verify(code)) {
            return "verification_success";
        } else {
            return "verification_failed";
        }
    }
}